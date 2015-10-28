package model;

import java.util.ArrayList;
import java.util.List;

import controller.PizzaSystem;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Order {
	
	private Customer customer;	
	private ObservableList<MenuItem> items;
	private ObservableList<Pizza> pizzas;
	private OrderStatus status;
	private DoubleProperty totalCost;

	public List<MenuItem> getItems() {
		return items;
	}

	public Customer getCustomer() {
		return customer;
	}
	
	/*
	 * Constructor to be used for creating orders
	 * for logged in customers. Creates the association
	 */
	public Order(Customer customer, PizzaSystem parentSystem){
		totalCost = new SimpleDoubleProperty();
		totalCost.set(0);
		this.customer = customer;
//		items = new ArrayList<MenuItem>();
		items  = FXCollections.observableArrayList();
		status = OrderStatus.pending;
//		pizzas = new ArrayList<Pizza>();
		pizzas = FXCollections.observableArrayList();
	}
	
	/*
	 * Default constructor. This is to be used for creating
	 * orders for non-logged in customers.
	 */
	public Order(){
		totalCost = new SimpleDoubleProperty();
		totalCost.set(0);
		this.customer = new Customer();
//		items = new ArrayList<MenuItem>();
//		pizzas = new ArrayList<Pizza>();
		items = FXCollections.observableArrayList();
		pizzas = FXCollections.observableArrayList();
		status = OrderStatus.pending;
	}

	public Order(List<MenuItem> items) {
		this.customer = new Customer();
//		this.items = items;
		this.items.setAll(items);
		status = OrderStatus.pending;
		tallyTotalPrice();
	}
	
	public Order(List<MenuItem> items, List<Pizza> pizzas) {
		this.customer = new Customer();
//		this.items = items;
//		this.pizzas = pizzas;
		this.items.setAll(items);
		this.pizzas.setAll(pizzas);
		status = OrderStatus.pending;
		tallyTotalPrice();
	}

	public Order(Customer customer, List<MenuItem> items, List<Pizza> pizzas) {
		this.customer = customer;
//		this.items = items;
//		this.pizzas = pizzas;
		this.items.setAll(items);
		this.pizzas.setAll(pizzas);
		status = OrderStatus.pending;
		tallyTotalPrice();
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
	
	public List<Pizza> getPizzas() {
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
		if (this == (o)){
			return true;
		}
		if ((o == null) || (o.getClass() != this.getClass())){
			return false;
		}
		Order c = (Order)o;
		return ((this.getCustomer().equals(c.getCustomer())) && (this.getItems().equals(c.getItems())) && (this.getPizzas().equals(c.getPizzas())) && (this.getOrderStatus().equals(c.getOrderStatus())));
	}
	
	@Override
	public String toString(){
		String temp = "";
		temp += "Customer: " + this.getCustomer().getName() + '\n';
		temp += "ITEMS:" + '\n';
		for (MenuItem mi : this.getItems()){
			temp += "    " + mi.toString();
		}
		temp += '\n';
		temp += "PIZZAS:" + '\n';
		for (Pizza pi : this.getPizzas()){
			temp += "    " + pi.toString() + '\n';
		}
		temp += "Order Status: " + this.getOrderStatus() + '\n' + '\n';
		return temp;
	}

	public void tallyTotalPrice() {
		double sum = 0;
		for (MenuItem mi : this.getItems()){
			sum += mi.getPrice();
		}
		for (Pizza pizza : this.getPizzas()){
			sum += pizza.getPrice();
		}
		totalCost.set(sum);
	}

	public void setOrderCustomer(Customer customer2) {
		this.customer = customer2;
	}

	public double getPrice() {
		return totalCost.get();
	}
	
	public DoubleProperty getPriceProperty() {
		return totalCost;
	}

	public void setOrderPrice(double totalSum) {
		this.totalCost.set(totalSum);
	}
}
