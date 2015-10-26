package controller;

import java.util.ArrayList;

import model.Customer;
import model.MenuItem;
import model.Order;
import model.OrderStatus;
import model.Pizza;
import model.PizzaException;
import model.Special;

public class OrderInterface {
	
	private PizzaSystem parentSystem;
	
	public OrderInterface(PizzaSystem system) {
		this.parentSystem = system;
	}
	
	public Order createNewOrder(ArrayList<MenuItem> items, ArrayList<Pizza> pizzas){
		Order temp = new Order(items, pizzas);
		addNewOrderToNotPreppedQueue(temp);
		return temp;
	}
	
	public Order createNewOrder(Customer customer, ArrayList<MenuItem> items, ArrayList<Pizza> pizzas) throws PizzaException{
		Order temp = new Order(customer, items, pizzas);
		if (!(parentSystem.getPizzaStore().getCustomers().contains(customer)) || (customer == null) || (items == null) || (pizzas == null) || !(checkOrderValidity(temp))){
			throw new PizzaException("Param error. OrderInterface.createNewOrder(Customer customer, ArrayList<MenuItem> items, ArrayList<Pizza> pizzas)");
		}
		else {
		addNewOrderToNotPreppedQueue(temp);
		}
		return temp;
	}
	
	private boolean checkOrderValidity(Order order){
		return ((checkOrderPizzaValidity(order.getPizzas())) && (checkOrderItemValidity(order.getItems())));
	}
	
	private boolean checkOrderItemValidity(ArrayList<MenuItem> items) {
		boolean valid = true;
		for (MenuItem mi : items){
			if (!(parentSystem.getPizzaStore().getMenu().getMenuItems().contains(mi))){
				valid = false;
			}
		}
		return valid;
	}

	private boolean checkOrderPizzaValidity(ArrayList<Pizza> pizzas) {
		boolean valid = true;
		for (Pizza pi : pizzas){
			if (!(parentSystem.getPizzaStore().getMenu().getPizzaSizes().contains(pi.getSize()))){
				valid = false;
			}
		}
		return valid;
	}

	public void applySpecialsToOrder(Order order) throws PizzaException{
		if ((order == null) || !((parentSystem.getPizzaStore().getOrderQueue().getCurrentOrders().contains(order)) || (parentSystem.getPizzaStore().getOrderQueue().getOrdersBeingMade().contains(order)) || (parentSystem.getPizzaStore().getOrderQueue().getPastOrders().contains(order)))){
			throw new PizzaException("Param error. OrderInterface.applySpecialsToOrder(Order order)");
		}
		else {
			order.tallyTotalPrice();
			double totalSum = 0;
			for (MenuItem mi : order.getItems()){
				//apply item pricing
				for (Special spec : parentSystem.getPizzaStore().getSpecials()){
					if (spec.getItem() == mi){// should this be .equals()?
						mi.setPrice(spec.getSpecialPrice());	
					}
					totalSum += mi.getPrice();
				}
			}
			for (Pizza pizza : order.getPizzas()){
				for (Special spec : parentSystem.getPizzaStore().getSpecials()){
					if (pizza.getSize() == spec.getSize()){
						pizza.setPrice((spec.getSpecialPrice() + ((pizza.getToppings().length - 1) * pizza.getPizzaToppingPrice()))) ;
					}
					totalSum += pizza.getPrice();
				}
			}
			order.setOrderPrice(totalSum);
		}
	}

	private void addNewOrderToNotPreppedQueue(Order order){
		parentSystem.getPizzaStore().getOrderQueue().getCurrentOrders().add(order);
	}
	
	/*
	 * Attempts to remove the order from the order queue.
	 * If successful, adds the order to the past orders.
	 */
	public void completeOrder(Order order) throws PizzaException{
		if ((order == null) || !(parentSystem.getPizzaStore().getOrderQueue().getOrdersBeingMade().contains(order)) || !(order.getOrderStatus() == model.OrderStatus.beingMade)){
			throw new PizzaException("Param error. OrderInterface.completeOrder(Order order)");
		}
		else {
			if (parentSystem.getPizzaStore().getOrderQueue().getOrdersBeingMade().remove(order)){
				order.setOrderStatus(OrderStatus.complete);
				parentSystem.getPizzaStore().getOrderQueue().getPastOrders().add(order);
			}
		}
	}
	

	/*
	 * Cancels an order currently being worked on. Moves it to complete
	 */
	public void cancelCurrentOrder(Order order) throws PizzaException{
		if ((order == null) || !(parentSystem.getPizzaStore().getOrderQueue().getCurrentOrders().contains(order)) || (order.getOrderStatus() != model.OrderStatus.pending)){
			throw new PizzaException("Bad param. OrderInterface.cancelCurrentOrder(Order order)");
		}
		else {
			if (parentSystem.getPizzaStore().getOrderQueue().getCurrentOrders().remove(order)){
				order.setStatus(OrderStatus.canceled);
				parentSystem.getPizzaStore().getOrderQueue().getCanceledOrders().add(order);
			}
		}
	}
	
	/*
	 * Grabs the next order, returns it.
	 * Places order into the ordersBeingMade queue.
	 */
	public Order grabNextOrder() throws PizzaException{
		Order temp;
		if (parentSystem.getPizzaStore().getOrderQueue().getCurrentOrders().size() > 0){
			temp = parentSystem.getPizzaStore().getOrderQueue().getCurrentOrders().remove(0);
			temp.setOrderStatus(OrderStatus.beingMade);
			parentSystem.getPizzaStore().getOrderQueue().getOrdersBeingMade().add(temp);
		}
		else {
			throw new PizzaException("OrderInterface.grabNextOrder() - No order to grab.");
		}
		return temp;
	}
	
	/*
	 * USED WHEN COOK STARTS WORKING ON AN ORDER. TAKES ORDER OUT OF
	 * THE currentOrder queue and places it in ordersBeingMade
	 */
	public void prepOrder(Order order) throws PizzaException{
		if ((order == null) || !(parentSystem.getPizzaStore().getOrderQueue().getCurrentOrders().contains(order)) || !(order.getOrderStatus() == model.OrderStatus.pending) || ((order.getItems().isEmpty() && order.getPizzas().isEmpty()))){
			throw new PizzaException("Param error. OrderInterface.prepOrder(Order order)");
		}
		else {
			//if order is in the current order queue
			parentSystem.getPizzaStore().getOrderQueue().getCurrentOrders().remove(order);
			order.setOrderStatus(OrderStatus.beingMade);
			parentSystem.getPizzaStore().getOrderQueue().getOrdersBeingMade().add(order);
		}
	}
	
	/*
	 * This searches the currentOrders queue, looking for the given order.
	 * Returns the order if found, else null
	 */
	public Order findInCurrentOrders(Order order) throws PizzaException{
		if ((order == null) || !(parentSystem.getPizzaStore().getOrderQueue().getCurrentOrders().contains(order))){
			throw new PizzaException("Param error. OrderInterface.findInCurrentOrders(Order order)");
		}
		else {
		for (Order o : parentSystem.getPizzaStore().getOrderQueue().getCurrentOrders()){
			if (order == o){
				return o;
			}
		}
		return null;
		}
	}

	public void addPizzaToOrder(Order order, Pizza pizza) throws PizzaException {
		if ((order == null) || (pizza == null) || !(checkOrderValidity(order)) || !(parentSystem.getPizzaStore().getMenu().getPizzaSizes().contains(pizza.getSize()))){
			throw new PizzaException("Param error. OrderInterface.addPizzaToOrder(Order order, Pizza pizza)");
		}
		else {
		Order temp = findInCurrentOrders(order);
		temp.getPizzas().add(pizza);
		}
	}

	public void addItemToOrder(Order order, MenuItem menuItem) throws PizzaException {
		if ((order == null) || (menuItem == null) || !(parentSystem.getPizzaStore().getOrderQueue().getCurrentOrders().contains(order)) || !(parentSystem.getPizzaStore().getMenu().getMenuItems().contains(menuItem))){
			throw new PizzaException("Param error. OrderInterface.addItemToOrder(Order order, MenuItem menuItem)");
		}
		else {
			Order temp = findInCurrentOrders(order);
			temp.getItems().add(menuItem);
		}
		
	}
}
