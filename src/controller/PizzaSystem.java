package controller;

import model.*;

public class PizzaSystem {
	
	private PizzaStore pizzaStore;
	private OrderInterface orderInterface;
	private ManagerInterface managerInterface;
	
	public PizzaSystem(){
		pizzaStore = new PizzaStore(this);
		orderInterface = new OrderInterface(this);
		managerInterface = new ManagerInterface(this);
	}
	
	public PizzaStore getPizzaStore(){
		return pizzaStore;
	}
	
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
		//PRINT SYSTEM IN DEFAULT (makes sure all constructors work, etc)
		PizzaSystem test = new PizzaSystem();
		System.out.println(test);
		//CREATE A NEW ORDER, ADD IT INTO QUEUE, PRINT SYSTEM
		Order testOrder = test.getOrderInterface().createNewOrder();
		test.getOrderInterface().addNewOrder(testOrder);
		System.out.println("~!~!~!~!~!~!~!~!~!~!~!~!~! ORDER HAS BEEN CREATED NOW ~!~!~!~!~!~!~!~!~!~!~!~!~!" + '\n');
		//This would normally be made by grabbing the "checked options" of a combo box. 
		PizzaTopping[] pt = { new PizzaTopping("Ham", "") , new PizzaTopping("Bacon", "") , new PizzaTopping("Pineapple", "") };
		//The size would also be part of a drop down/combo box
		test.getOrderInterface().addPizzaToOrder(testOrder, new Pizza(pt, PizzaSize.SMALL));
		test.getOrderInterface().addItemToOrder(testOrder, new MenuItem((long)5.00, "6 pc Buffalo Wings", ""));
		System.out.println(test);
		System.out.println("~!~!~!~!~!~!~!~!~!~!~!~!~! ORDER HAS BEEN MOVED NOW ~!~!~!~!~!~!~!~!~!~!~!~!~!" + '\n');
		//THIS SHOULD TAKE THE ORDER OUT OF THE PENDING QUEUE AND PLACE IT IN THE BEING WORKED ON QUEUE
		test.getOrderInterface().grabNextOrder();
		System.out.println(test);
		
	}
}
