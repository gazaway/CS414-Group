package model;

import java.util.ArrayList;

public class Order {
	
	private Customer customer;	
	private ArrayList<MenuItem> items;

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
	public Order(Customer customer_){
		this.customer = customer_;
		items = new ArrayList<MenuItem>();
	}
	
	/*
	 * Default constructor. This is to be used for creating
	 * orders for non-logged in customers.
	 */
	public Order(){
		this.customer = new Customer();
		items = new ArrayList<MenuItem>();
	}
}
