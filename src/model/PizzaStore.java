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

	public boolean checkSpecialsForPizzaSize(PizzaSize size) {
		boolean temp = false;
		for (Special spec : specials){
			if (spec.hasPizzaSize()){
				if (spec.getSize() == size){
					temp = true;
				}
			}
		}
		return temp;
	}
	
	public boolean checkSpecialsForItem(MenuItem item) {
		boolean temp = false;
		for (Special spec : specials){
			if (spec.hasItem()){
				if (spec.getItem() == item){
					temp = true;
				}
			}
		}
		return temp;
	}

	public Special findSpecialBySize(PizzaSize size) {
		Special temp = new Special("NOT EVER USED");
		for (Special spec : this.getSpecials()){
			if (spec.hasPizzaSize()){
				if (spec.getSize() == size){
					temp = spec;
				}
			}
		}
		return temp;
	}

	public Special findSpecialByItem(MenuItem item) {
		Special temp = new Special("NOT EVER USED");
		for (Special spec : this.getSpecials()){
			if (spec.hasItem()){
				if (spec.getItem() == item){
					temp = spec;
				}
			}
		}
		return temp;
	}

	public ArrayList<Customer> getCustomers() {
		return this.customers;
	}
}
