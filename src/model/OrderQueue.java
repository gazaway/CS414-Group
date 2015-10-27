package model;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import controller.PizzaSystem;

public class OrderQueue {
	
	private ObservableList<Order> currentOrdersNotPrepped; // order that's been placed
	private ObservableList<Order> ordersBeingMade; //orders being made by cooks at the moment
	private ObservableList<Order> canceledOrders; // online orders for cash pick-up
	private ObservableList<Order> pastOrders;
	private PizzaSystem parentSystem;
	
	public OrderQueue(PizzaSystem system){
//		currentOrdersNotPrepped = new ArrayList<Order>();
//		canceledOrders = new ArrayList<Order>();
//		ordersBeingMade = new ArrayList<Order>();
//		pastOrders =  new ArrayList<Order>();
		currentOrdersNotPrepped = FXCollections.observableArrayList();
		canceledOrders = FXCollections.observableArrayList();
		ordersBeingMade = FXCollections.observableArrayList();
		pastOrders =  FXCollections.observableArrayList();
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

	public List<Order> getCanceledOrders() {
		return this.canceledOrders;
	}
}
