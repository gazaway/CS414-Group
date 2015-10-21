package model;

import java.util.ArrayList;

import controller.PizzaSystem;

public class OrderQueue {
	
	private ArrayList<Order> currentOrders; // order that's been placed
	private ArrayList<Order> ordersBeingMade; //orders being made by cooks at the moment
	private ArrayList<Order> completedUnpaidOrders; // online orders for cash pick-up
	private ArrayList<Order> pastOrders;
	private PizzaSystem parentSystem;
	
	public OrderQueue(PizzaSystem system){
		currentOrders = new ArrayList<Order>();
		ordersBeingMade = new ArrayList<Order>();
		pastOrders =  new ArrayList<Order>();
		parentSystem = system;
	}
	
	public ArrayList<Order> getCurrentOrders(){
		return currentOrders;
	}

	public ArrayList<Order> getPastOrders() {
		return pastOrders;
	}

	public ArrayList<Order> getOrdersBeingMade() {
		return ordersBeingMade;
	}
}
