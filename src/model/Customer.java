package model;

public class Customer {
	
	private ContactInfo contactInfo;
	
	/*
	 * Create customer with known information. Probably not used much
	 */
	public Customer(String name, String address, String phone){
		this.contactInfo = new ContactInfo(name, address, phone);
	}
	
	/*
	 * Default constructor for customer creation with no information.
	 * Will be used often for order creation.
	 */
	public Customer(){
		this.contactInfo = new ContactInfo();
	}
	
	public void setName(String name){
		contactInfo = new ContactInfo(name, contactInfo.getAddress(), contactInfo.getPhone());
	}
	
	public void setAddress(String address){
		contactInfo = new ContactInfo(contactInfo.getName(), address, contactInfo.getPhone());
	}

	public void setPhone(String phone){
		contactInfo = new ContactInfo(contactInfo.getName(), contactInfo.getAddress(), phone);
	}

	public String getName() {
		return this.contactInfo.getName();
	}
}
