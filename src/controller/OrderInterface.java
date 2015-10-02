package controller;

import java.util.LinkedList;

import model.*;

public class OrderInterface {
	
	private System parentSystem;
	
	public OrderInterface(System system) {
		parentSystem = system;
	}

	public void addNewOrder(Order order){
		parentSystem.getOrderQueue().getCurrentOrders().add(order);
		//TODO GUI CALLS
	}
	
	/*
	 * Attempts to remove the order from the order queue.
	 * If successful, adds the order to the past orders.
	 */
	public void completeOrder(Order order){
		if (parentSystem.getOrderQueue().getCurrentOrders().remove(order)){
			parentSystem.getOrderQueue().getPastOrders().add(order);
			//TODO GUI CALLS
		}
	}
	
	/*
	 * Cancels an order currently being worked on.
	 */
	public void cancelCurrentOrder(Order order){
		if (parentSystem.getOrderQueue().getCurrentOrders().remove(order)){
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
		if (!parentSystem.getOrderQueue().getCurrentOrders().isEmpty()){
			temp = parentSystem.getOrderQueue().getCurrentOrders().poll();
			parentSystem.getOrderQueue().getOrdersBeingMade().add(temp);
			//TODO GUI CALLS
		}
		return temp;
	}
}
