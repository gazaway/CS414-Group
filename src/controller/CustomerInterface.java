package controller;

import model.Customer;
import model.PizzaException;

public class CustomerInterface {
	
	private PizzaSystem parentSystem;

	public CustomerInterface(PizzaSystem pizzaSystem) {
		this.parentSystem = pizzaSystem;
	}
	
	public Customer createNewCustProfile(String name, String address, String phone) throws PizzaException{
		Customer temp = new Customer(name, address, phone);
		if ((name.trim().equals("")) || (name == null) || (address.trim().equals("")) || (address == null) || (phone.trim().equals("")) || (phone == null)){
			throw new PizzaException("Param error. CustomerInterface.createNewCustProfile(String name, String address, String phone)");
		}
		else {
			parentSystem.getPizzaStore().getCustomers().add(temp);
		}
		return temp;
	}

	public void editCustomerName(Customer cust, String name) throws PizzaException{
		if(!(parentSystem.getPizzaStore().getCustomers().contains(cust)) || (cust == null) || (name.trim().equals("")) || (name == null)){
			throw new PizzaException("Param error. CustomerInterface.editCustomerName(Customer cust, String name)");
		}
		else {
			Customer temp = parentSystem.getPizzaStore().getCustomers().get(parentSystem.getPizzaStore().getCustomers().indexOf(cust));
			temp.setName(name);
		}
	}
	
	public void editCustomerAddress(Customer cust, String address) throws PizzaException{
		if(!(parentSystem.getPizzaStore().getCustomers().contains(cust)) || (cust == null) || (address.trim().equals("")) || (address == null)){
			throw new PizzaException("Param error. CustomerInterface.editCustomerName(Customer cust, String name)");
		}
		else {
			Customer temp = parentSystem.getPizzaStore().getCustomers().get(parentSystem.getPizzaStore().getCustomers().indexOf(cust));
			temp.setAddress(address);
		}
	}
	
	public void editCustomerPhone(Customer cust, String phone) throws PizzaException{
		if(!(parentSystem.getPizzaStore().getCustomers().contains(cust)) || (cust == null) || (phone.trim().equals("")) || (phone == null)){
			throw new PizzaException("Param error. CustomerInterface.editCustomerName(Customer cust, String name)");
		}
		else {
			Customer temp = parentSystem.getPizzaStore().getCustomers().get(parentSystem.getPizzaStore().getCustomers().indexOf(cust));
			temp.setPhone(phone);
		}
	}
	
	public model.ContactInfo addNewContactInfo(Customer cust, model.ContactInfo contactInfo) throws PizzaException{
		if(!(parentSystem.getPizzaStore().getCustomers().contains(cust)) || (cust == null) || (contactInfo == null)){
			throw new PizzaException("Param error. CustomerInterface.editCustomerName(Customer cust, String name)");
		}
		else {
			Customer temp = parentSystem.getPizzaStore().getCustomers().get(parentSystem.getPizzaStore().getCustomers().indexOf(cust));
			model.ContactInfo ci = temp.addNewContactInfo(contactInfo);
			return ci;
		}
	}
}
