package model;

public class Cashier {
	
	private ContactInfo contactInfo;
	
	public Cashier(String name, String address, String phone){
		this.setContactInfo(new ContactInfo(name, address, phone));
	}

	public ContactInfo getContactInfo() {
		return contactInfo;
	}

	public void setContactInfo(ContactInfo contactInfo) {
		this.contactInfo = contactInfo;
	}
}
