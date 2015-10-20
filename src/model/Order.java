package model;

import java.util.LinkedList;

public class Order {
	
	private Customer customer;	
	private LinkedList<MenuItem> items;
	private LinkedList<Pizza> pizzas;
	private OrderStatus status;

	public LinkedList<MenuItem> getItems() {
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
		items = new LinkedList<MenuItem>();
		status = OrderStatus.pending;
	}
	
	/*
	 * Default constructor. This is to be used for creating
	 * orders for non-logged in customers.
	 */
	public Order(){
		this.customer = new Customer();
		items = new LinkedList<MenuItem>();
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

	public OrderStatus getOrderStatus(){
		return this.status;
	}
	
	public void setOrderStatus(OrderStatus status){
		this.status = status;
	}
	
	public LinkedList<Pizza> getPizzas() {
		return pizzas;
	}
}
