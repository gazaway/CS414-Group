package model;

public class Customer {
	
	private ContactInfo contactInfo;
	
	public Customer(String name, String address, String phone){
		this.contactInfo = new ContactInfo(name, address, phone);
	}
	
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
}
