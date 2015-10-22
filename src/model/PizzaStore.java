package model;

import java.util.ArrayList;

import controller.*;

public class PizzaStore {

	private ArrayList<Cashier> cashiers;
	private ArrayList<Manager> managers;
	private ArrayList<Cook> cooks;
	private ArrayList<Customer> customers;
	private ArrayList<Special> specials;
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

	public ArrayList<Special> getSpecials() {
		return specials;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}
}
