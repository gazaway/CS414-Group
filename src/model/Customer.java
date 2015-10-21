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
		setName("Default Name");
		setAddress("Default Address");
		setPhone("Default Phone");
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
	
	public String getPhone(){
		return this.contactInfo.getPhone();
	}
	
	public String getAddress(){
		return this.getContactInfo().getAddress();
	}
	
	public ContactInfo getContactInfo(){
		return this.contactInfo;
	}
	
	/*
	 * Equals overrides are needed so we can use pre-made containers that use .contains
	 */
	@Override
	public int hashCode(){
		int hash = 7;
		hash = 31 * hash + (contactInfo == null ? 0 : this.getContactInfo().hashCode());
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
}
