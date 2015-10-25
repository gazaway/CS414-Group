package controller;

import model.Customer;

public class CustomerInterface {
	
	private PizzaSystem parentSystem;

	public CustomerInterface(PizzaSystem pizzaSystem) {
		this.parentSystem = pizzaSystem;
	}
	
	public Customer createNewCustProfile(String name, String address, String phone){
		Customer temp = new Customer(name, address, phone);
		parentSystem.getPizzaStore().getCustomers().add(temp);
		return temp;
	}

}
