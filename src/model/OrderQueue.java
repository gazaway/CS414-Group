package model;

import java.util.ArrayList;
import java.util.List;

import controller.PizzaSystem;

public class OrderQueue {
	
	private List<Order> currentOrdersNotPrepped; // order that's been placed
	private List<Order> ordersBeingMade; //orders being made by cooks at the moment
	private List<Order> canceledOrders; // online orders for cash pick-up
	private List<Order> pastOrders;
	private PizzaSystem parentSystem;
	
	public OrderQueue(PizzaSystem system){
		currentOrdersNotPrepped = new ArrayList<Order>();
		canceledOrders = new ArrayList<Order>();
		ordersBeingMade = new ArrayList<Order>();
		pastOrders =  new ArrayList<Order>();
		parentSystem = system;
	}
	
	public List<Order> getCurrentOrders(){
		return currentOrdersNotPrepped;
	}

	public List<Order> getPastOrders() {
		return pastOrders;
	}

	public List<Order> getOrdersBeingMade() {
		return ordersBeingMade;
	}
	
	public List<Order> getUnpaidOrders(){
		return canceledOrders;
	}

	public List<Order> getCanceledOrders() {
		// TODO Auto-generated method stub
		return null;
	}
}
