package controller;

import java.util.LinkedList;

import model.*;

public class OrderQueue {
	
	private LinkedList<Order> currentOrders;
	private LinkedList<Order> ordersBeingMade;
	private LinkedList<Order> pastOrders;
	
	public OrderQueue(){
		currentOrders = new LinkedList<Order>();
		pastOrders = new LinkedList<Order>();
		ordersBeingMade = new LinkedList<Order>();
	}
	
	public void addNewOrder(Order order){
		currentOrders.add(order);
		//TODO GUI CALLS
	}
	
	/*
	 * Attempts to remove the order from the order queue.
	 * If successful, adds the order to the past orders.
	 */
	public void completeOrder(Order order){
		if (currentOrders.remove(order)){
			pastOrders.add(order);
			//TODO GUI CALLS
		}
	}
	
	/*
	 * Cancels an order currently being worked on.
	 */
	public void cancelCurrentOrder(Order order){
		if (currentOrders.remove(order)){
			order.setStatus(OrderStatus.canceled);
			//TODO GUI CALLS
		}
	}
	
	/*
	 * Grabs the next order, returns it.
	 * Places order into the ordersBeingMade queue.
	 */
	public Order grabNextOrder(){
		Order temp = new Order();
		if (!currentOrders.isEmpty()){
			temp = currentOrders.poll();
			ordersBeingMade.add(temp);
			//TODO GUI CALLS
		}
		return temp;
	}
}
