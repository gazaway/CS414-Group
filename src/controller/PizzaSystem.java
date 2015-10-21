package controller;

import model.*;

public class PizzaSystem {
	
	private PizzaStore pizzaStore;
	private OrderQueue orderQueue;
	private OrderInterface orderInterface;
	private ManagerInterface managerInterface;
	
	public PizzaSystem(){
		pizzaStore = new PizzaStore(this);
		orderQueue = new OrderQueue(this);
		orderInterface = new OrderInterface(this);
		managerInterface = new ManagerInterface(this);
	}

	public OrderQueue getOrderQueue() {
		return this.orderQueue;
	}
	
	public PizzaStore getStore(){
		return pizzaStore;
	}
	
	public String toString(){
		String temp = "";
		temp += "The pizza store has " + getOrderQueue().getCurrentOrders().size() + " current orders waiting to be made." + '\n';
		temp += "There are " + getOrderQueue().getOrdersBeingMade().size() + " orders being made right now." + '\n';
		temp += "This store has fulfilled " + getOrderQueue().getPastOrders().size() + " orders total in the past." + '\n';
		temp += "LIST OF ORDERS WAITING TO BE MADE:" + '\n';
		temp += "----------------------------------" + '\n';
		for (Order o : orderQueue.getCurrentOrders()){
			temp += o.toString() + '\n';
		}
		temp += "LIST OF ORDERS CURRENTLY BEIGN MADE:" + '\n';
		temp += "------------------------------------" + '\n';
		for (Order o : orderQueue.getOrdersBeingMade()){
			temp += o.toString() + '\n';
		}
		return temp;
	}
	
	public OrderInterface getOrderInterface() {
		return orderInterface;
	}
	
	public ManagerInterface getManagerInterface() {
		return managerInterface;
	}
	
	public static void main(String[]args){
		PizzaSystem test = new PizzaSystem();
		System.out.println(test);
		Order testOrder = test.getOrderInterface().createNewOrder();
		test.getOrderInterface().addNewOrder(testOrder);
		System.out.println("~!~!~!~!~!~!~!~!~!~!~!~!~! ORDER HAS BEEN CREATED NOW ~!~!~!~!~!~!~!~!~!~!~!~!~!" + '\n');
		System.out.println(test);
	}
}
