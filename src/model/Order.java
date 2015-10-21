package model;

import java.util.ArrayList;

public class Order {
	
	private Customer customer;	
	private ArrayList<MenuItem> items;
	private ArrayList<Pizza> pizzas;
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
		pizzas = new ArrayList<Pizza>();
	}
	
	/*
	 * Default constructor. This is to be used for creating
	 * orders for non-logged in customers.
	 */
	public Order(){
		this.customer = new Customer();
		items = new ArrayList<MenuItem>();
		pizzas = new ArrayList<Pizza>();
		status = OrderStatus.pending;
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
	
	public ArrayList<Pizza> getPizzas() {
		return pizzas;
	}
	
	/*
	 * Equals overrides are needed so we can use pre-made containers that use .contains
	 */
	@Override
	public int hashCode(){
		int hash = 7;
		hash = 31 * hash + (customer == null ? 0 : this.getCustomer().hashCode());
		hash = 31 * hash + (items == null ? 0 : this.getItems().hashCode());
		hash = 31 * hash + (pizzas == null ? 0 : this.getPizzas().hashCode());
		hash = 31 * hash + (status == null ? 0 : this.getOrderStatus().hashCode());
		return hash;
	}
	
	@Override
	public boolean equals(Object o){
		if (this == o){
			return true;
		}
		if ((o == null) || (o.getClass() != this.getClass())){
			return false;
		}
		Order c = (Order)o;
		return ((this.getCustomer() == c.getCustomer()) && (this.getItems() == c.getItems()) && (this.getPizzas() == c.getPizzas()) && (this.getOrderStatus() == c.getOrderStatus()));
	}
	
	@Override
	public String toString(){
		String temp = "";
		temp += "Customer: " + this.getCustomer().getName() + '\n';
		temp += "---------ITEMS--------" + '\n';
		for (MenuItem mi : this.getItems()){
			temp += "    " + mi.toString();
		}
		temp += '\n';
		temp += "---------PIZZAS-------" + '\n';
		for (Pizza pi : this.getPizzas()){
			temp += "    " + pi.toString() + '\n';
		}
		temp += "Order Status: " + this.getOrderStatus() + '\n' + '\n';
		return temp;
	}
}
