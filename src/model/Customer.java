package model;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	
	private List<ContactInfo> contactList;
	
	/*
	 * Create customer with known information. Probably not used much
	 */
	public Customer(String name, String address, String phone){
		contactList = new ArrayList<ContactInfo>();
		this.contactList.add(new ContactInfo(name, address, phone));
	}
	
	/*
	 * Default constructor for customer creation with no information.
	 * Will be used often for order creation.
	 */
	public Customer(){
		this.contactList = new ArrayList<ContactInfo>();
		this.contactList.add(new ContactInfo("Default Name", "Default Address", "Default Phone"));
	}
	
	public void setName(String name){
		ContactInfo temp = this.contactList.get(contactList.size() - 1);
		temp.setName(name);
	}
	
	public void setAddress(String address){
		ContactInfo temp = this.contactList.get(contactList.size() - 1);
		temp.setAddress(address);
	}

	public void setPhone(String phone){
		ContactInfo temp = this.contactList.get(contactList.size() - 1);
		temp.setPhone(phone);
	}

	public String getName() {
		ContactInfo temp = this.contactList.get(contactList.size() - 1);
		return temp.getName();
	}
	
	public String getPhone(){
		ContactInfo temp = this.contactList.get(contactList.size() - 1);
		return temp.getPhone();
	}
	
	public String getAddress(){
		ContactInfo temp = this.contactList.get(contactList.size() - 1);
		return temp.getAddress();
	}
	
	public ContactInfo getContactInfo(){
		return this.contactList.get(contactList.size() - 1);
	}
	
	/*
	 * Equals overrides are needed so we can use pre-made containers that use .contains
	 */
	@Override
	public int hashCode(){
		int hash = 7;
		hash = 31 * hash + (contactList == null ? 0 : this.getContactInfo().hashCode());
		return hash;
	}
	
	@Override
	public boolean equals(Object o){
		if (this == o){
			return true;
		}
		if ((o == null) || (o.getClass() != this.getClass())){
			return false;
		}
		Customer c = (Customer)o;
		return (this.getContactInfo() == c.getContactInfo());
	}
	
	@Override
	public String toString(){
		String temp = "";
		temp += this.getName() + '\n';
		temp += this.getAddress() + '\n';
		temp += this.getPhone();
		return temp;
	}

	public ContactInfo addNewContactInfo(ContactInfo contactInfo) {
		this.contactList.add(contactInfo);
		return contactInfo;
	}
}
