package controller;

import model.*;

public class System {
	
	private PizzaStore pizzaStore;
	private OrderQueue orderQueue;
	private OrderInterface orderInterface;
	
	public System(){
		pizzaStore = new PizzaStore(this);
		orderQueue = new OrderQueue(this);
		orderInterface = new OrderInterface(this);
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
	
	public static void main(String[]args){
		System test = new System();
	}
}
