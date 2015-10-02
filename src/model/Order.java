package model;

import java.util.ArrayList;

public class Order {
	
	private Customer customer;	
	private ArrayList<MenuItem> items;
	private OrderStatus status;

	public ArrayList<MenuItem> getItems() {
		return items;
	}

	public Customer getCustomer() {
		return customer;
	}
	
	/*
	 * Constructor to be used for creating orders
	 * for logged in customers. Creates the association
	 */
	public Order(Customer customer){
		this.customer = customer;
		items = new ArrayList<MenuItem>();
		status = OrderStatus.pending;
	}
	
	/*
	 * Default constructor. This is to be used for creating
	 * orders for non-logged in customers.
	 */
	public Order(){
		this.customer = new Customer();
		items = new ArrayList<MenuItem>();
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	
	/*
	 * Return true if no items in menu item
	 */
	public boolean isEmpty(){
		return items.isEmpty();
	}
}
