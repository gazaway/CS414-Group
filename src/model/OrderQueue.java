package model;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import controller.PizzaSystem;

public class OrderQueue {
	
//	private List<Order> currentOrdersNotPrepped; // order that's been placed
	private ObservableList <Order> currentOrdersNotPrepped;
//	private List<Order> ordersBeingMade; //orders being made by cooks at the moment
	private ObservableList <Order> ordersBeingMade;
	private List<Order> canceledOrders; // online orders for cash pick-up
	private List<Order> pastOrders;
	private PizzaSystem parentSystem;
	
	public OrderQueue(PizzaSystem system){
//		currentOrdersNotPrepped = new ArrayList<Order>();
		canceledOrders = new ArrayList<Order>();
//		ordersBeingMade = new ArrayList<Order>();
		pastOrders =  new ArrayList<Order>();
		currentOrdersNotPrepped = FXCollections.observableArrayList();
		ordersBeingMade = FXCollections.observableArrayList();
//		parentSystem = system;
	}
	
	public OrderQueue(OrderQueue queue){
//		currentOrdersNotPrepped = new ArrayList<Order>();
		canceledOrders = new ArrayList<Order>(queue.getCanceledOrders());
//		ordersBeingMade = new ArrayList<Order>();
		pastOrders =  new ArrayList<Order>(queue.getPastOrders());
		currentOrdersNotPrepped = FXCollections.observableArrayList();
		currentOrdersNotPrepped.setAll(queue.getCurrentOrders());
		ordersBeingMade = FXCollections.observableArrayList();
		ordersBeingMade.setAll(queue.getOrdersBeingMade());
//		parentSystem = system;
	}
	
	public ObservableList<Order> getCurrentOrders(){
		return currentOrdersNotPrepped;
	}

	public List<Order> getPastOrders() {
		return pastOrders;
	}

	public ObservableList<Order> getOrdersBeingMade() {
		return ordersBeingMade;
	}

	public List<Order> getCanceledOrders() {
		return this.canceledOrders;
	}
}
