package model;

import java.util.ArrayList;
import java.util.List;

import controller.*;

public class PizzaStore {

	private List<Cashier> cashiers;
	private List<Manager> managers;
	private List<Cook> cooks;
	private List<Customer> customers;
	private List<Special> specials;
	private PizzaSystem parentSystem;
	private Menu menu;
	private OrderQueue orderQueue;
	
	public PizzaStore(PizzaSystem system){
		cashiers = new ArrayList<Cashier>();
		managers = new ArrayList<Manager>();
		cooks = new ArrayList<Cook>();
		customers = new ArrayList<Customer>();
		specials = new ArrayList<Special>();
		parentSystem = system;
		menu = new Menu();
		orderQueue = new OrderQueue(parentSystem);
	}
	
	public Menu getMenu(){
		return this.menu;
	}
	
	public OrderQueue getOrderQueue(){
		return this.orderQueue;
	}

	public List<Special> getSpecials() {
		return specials;
	}
}
