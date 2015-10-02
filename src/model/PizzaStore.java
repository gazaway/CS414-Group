package model;

import java.util.ArrayList;
import controller.*;

public class PizzaStore {

	private ArrayList<Cashier> cashiers;
	private ArrayList<Manager> managers;
	private ArrayList<Cook> cooks;
	private OrderQueue currentOrders;
	private ArrayList<Customer> customers;
	
	public PizzaStore(){
		cashiers = new ArrayList<Cashier>();
		managers = new ArrayList<Manager>();
		cooks = new ArrayList<Cook>();
		currentOrders = new OrderQueue();
		customers = new ArrayList<Customer>();
	}
	
}
