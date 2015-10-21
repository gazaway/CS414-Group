package model;

import java.util.LinkedList;

import controller.PizzaSystem;

public class OrderQueue {
	
	private LinkedList<Order> currentOrders; // order that's been placed
	private LinkedList<Order> ordersBeingMade; //orders being made by cooks at the moment
	private LinkedList<Order> completedUnpaidOrders; // online orders for cash pick-up
	private LinkedList<Order> pastOrders;
	private PizzaSystem parentSystem;
	
	public OrderQueue(PizzaSystem system){
		currentOrders = new LinkedList<Order>();
		ordersBeingMade = new LinkedList<Order>();
		pastOrders =  new LinkedList<Order>();
		parentSystem = system;
	}
	
	public LinkedList<Order> getCurrentOrders(){
		return currentOrders;
	}

	public LinkedList<Order> getPastOrders() {
		return pastOrders;
	}

	public LinkedList<Order> getOrdersBeingMade() {
		return ordersBeingMade;
	}
}
