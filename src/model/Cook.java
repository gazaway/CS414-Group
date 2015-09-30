package model;

public class Cook {
	
	private ContactInfo contactInfo;
	
	public Cook(String name, String address, String phone){
		this.setContactInfo(new ContactInfo(name, address, phone));
	}

	public ContactInfo getContactInfo() {
		return contactInfo;
	}

	public void setContactInfo(ContactInfo contactInfo) {
		this.contactInfo = contactInfo;
	}

}
