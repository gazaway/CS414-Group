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

	public void editCustomerName(Customer cust, String name){
		Customer temp = parentSystem.getPizzaStore().getCustomers().get(parentSystem.getPizzaStore().getCustomers().indexOf(cust));
		temp.setName(name);
	}
	
	public void editCustomerAddress(Customer cust, String address){
		Customer temp = parentSystem.getPizzaStore().getCustomers().get(parentSystem.getPizzaStore().getCustomers().indexOf(cust));
		temp.setAddress(address);
	}
	
	public void editCustomerPhone(Customer cust, String phone){
		Customer temp = parentSystem.getPizzaStore().getCustomers().get(parentSystem.getPizzaStore().getCustomers().indexOf(cust));
		temp.setPhone(phone);
	}
	
	public model.ContactInfo addNewContactInfo(Customer cust, model.ContactInfo contactInfo){
		Customer temp = parentSystem.getPizzaStore().getCustomers().get(parentSystem.getPizzaStore().getCustomers().indexOf(cust));
		model.ContactInfo ci = temp.addNewContactInfo(contactInfo);
		return ci;
	}
}
