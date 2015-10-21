package model;

import java.util.ArrayList;

import controller.*;
import controller.PizzaSystem;

public class PizzaStore {

	private ArrayList<Cashier> cashiers;
	private ArrayList<Manager> managers;
	private ArrayList<Cook> cooks;
	private ArrayList<Customer> customers;
	private PizzaSystem parentSystem;
	private Menu menu;
	
	public PizzaStore(PizzaSystem system){
		cashiers = new ArrayList<Cashier>();
		managers = new ArrayList<Manager>();
		cooks = new ArrayList<Cook>();
		customers = new ArrayList<Customer>();
		parentSystem = system;
		menu = new Menu();
	}
	
	public Menu getMenu(){
		return this.menu;
	}
}
