package model;

import java.util.LinkedList;

import controller.System;

public class OrderQueue {
	
	private LinkedList<Order> currentOrders;
	private LinkedList<Order> ordersBeingMade;
	private LinkedList<Order> pastOrders;
	private System parentSystem;
	
	public OrderQueue(System system){
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
