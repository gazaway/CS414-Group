package controller;

import model.*;

public class PizzaSystem {
	
	private PizzaStore pizzaStore;
	private OrderInterface orderInterface;
	private ManagerInterface managerInterface;
	private Main orderMain;
	
	public PizzaSystem(){
		pizzaStore = new PizzaStore(this);
		orderInterface = new OrderInterface(this);
		managerInterface = new ManagerInterface(this);
		orderMain = new Main();
		orderMain.run(new String[0]);
		this.getPizzaStore().getMenu().loadMenuFromFile();
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
	 * This is a test run main. In reality, we should be creating an instance of our GUI and making it run.
	 * But this will work for now.
	 */
	public static void main(String[]args){
		PizzaSystem test = new PizzaSystem();
	}

	/*
	 * Method used for testing purposes only.
	 */
	public void clearSystem() {
		pizzaStore = new PizzaStore(this);
		orderInterface = new OrderInterface(this);
		managerInterface = new ManagerInterface(this);
	}
}
