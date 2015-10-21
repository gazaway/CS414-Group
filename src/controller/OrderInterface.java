package controller;

import model.*;

public class OrderInterface {
	
	private PizzaSystem parentSystem;
	
	public OrderInterface(PizzaSystem system) {
		this.parentSystem = system;
	}
	
	public Order createNewOrder(){
		return new Order();
	}
	
	public Order createNewOrder(Customer customer){
		return new Order(customer);
	}

	public void addNewOrder(Order order){
		parentSystem.getOrderQueue().getCurrentOrders().add(order);
		//TODO GUI CALLS
	}
	
	/*
	 * Attempts to remove the order from the order queue.
	 * If successful, adds the order to the past orders.
	 */
	public void completeOrder(Order order){
		if (parentSystem.getOrderQueue().getCurrentOrders().remove(order)){
			parentSystem.getOrderQueue().getPastOrders().add(order);
			//TODO GUI CALLS
		}
	}
	
	/*
	 * Cancels an order currently being worked on. Moves it to complete
	 */
	public void cancelCurrentOrder(Order order){
		if (parentSystem.getOrderQueue().getCurrentOrders().remove(order)){
			order.setStatus(OrderStatus.canceled);
			parentSystem.getOrderQueue().getPastOrders().add(order);
			//TODO GUI CALLS FOR REFRESH, ETC.
		}
	}
	
	/*
	 * Grabs the next order, returns it.
	 * Places order into the ordersBeingMade queue.
	 */
	public Order grabNextOrder(){
		Order temp = new Order();
		if (!parentSystem.getOrderQueue().getCurrentOrders().isEmpty()){
			temp = parentSystem.getOrderQueue().getCurrentOrders().poll();
			parentSystem.getOrderQueue().getOrdersBeingMade().add(temp);
			//TODO GUI CALLS
		}
		return temp;
	}
	
	/*
	 * USED WHEN COOK STARTS WORKING ON AN ORDER. TAKES ORDER OUT OF
	 * THE currentOrder queue and places it in ordersBeingMade
	 */
	public void prepOrder(Order order){
		//if order is in the current order queue
		if (parentSystem.getOrderQueue().getCurrentOrders().remove(order)){
			parentSystem.getOrderQueue().getOrdersBeingMade().add(order);
		}
	}
}
