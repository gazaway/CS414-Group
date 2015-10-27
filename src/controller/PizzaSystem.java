package controller;

import model.*;

public class PizzaSystem {
	
	private PizzaStore pizzaStore;
	private OrderInterface orderInterface;
	private ManagerInterface managerInterface;
	private CustomerInterface customerInterface;
	private Main orderMain;

	private static PizzaSystem instance;
	
	private PizzaSystem() {
		pizzaStore = new PizzaStore(this);
		orderInterface = new OrderInterface(this);
		managerInterface = new ManagerInterface(this);
		customerInterface = new CustomerInterface(this);
		orderMain = new Main();
		orderMain.run(new String[0]);
		this.getPizzaStore().getMenu().loadMenuFromFile();
	}
	
	public static PizzaSystem getInstance() {
		if(null == instance) {
			instance = new PizzaSystem();
		}
		return instance;
	}
	
	public PizzaStore getPizzaStore(){
		return pizzaStore;
	}
	
	@Override
	public String toString(){
		String temp = "";
		temp += "The pizza store has " + getPizzaStore().getOrderQueue().getCurrentOrders().size() + " current orders waiting to be made." + '\n';
		temp += "There are " + getPizzaStore().getOrderQueue().getOrdersBeingMade().size() + " orders being made right now." + '\n';
		temp += "This store has fulfilled " + getPizzaStore().getOrderQueue().getPastOrders().size() + " orders total in the past." + '\n';
		temp += "LIST OF ORDERS WAITING TO BE MADE:" + '\n';
		temp += "----------------------------------" + '\n';
		if (getPizzaStore().getOrderQueue().getCurrentOrders().isEmpty()){
			temp += "[NO ORDERS]" + '\n' + '\n';
		}
		else {
			for (Order o : getPizzaStore().getOrderQueue().getCurrentOrders()){
				temp += o.toString() + '\n';
			}
		}
		temp += "LIST OF ORDERS CURRENTLY BEING MADE:" + '\n';
		temp += "------------------------------------" + '\n';
		if (getPizzaStore().getOrderQueue().getOrdersBeingMade().isEmpty()){
			temp += "[NO ORDERS]" + '\n' + '\n';
		}
		else {
			for (Order o : getPizzaStore().getOrderQueue().getOrdersBeingMade()){
				temp += o.toString() + '\n';
			}
		}
		return temp;
	}
	
	public OrderInterface getOrderInterface() {
		return orderInterface;
	}
	
	public ManagerInterface getManagerInterface() {
		return managerInterface;
	}

	/*
	 * Method used for testing purposes only.
	 */
	public void clearSystem() {
		pizzaStore = new PizzaStore(this);
		orderInterface = new OrderInterface(this);
		managerInterface = new ManagerInterface(this);
	}

	public CustomerInterface getCustomerInterface() {
		return this.customerInterface;
	}
}
