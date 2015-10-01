package model;

public class SystemAdmin {
	
	private ContactInfo contactInfo;
	
	public SystemAdmin(String name, String address, String phone){
		setContactInfo(new ContactInfo(name, address, phone));
	}

	public ContactInfo getContactInfo() {
		return contactInfo;
	}

	public void setContactInfo(ContactInfo contactInfo) {
		this.contactInfo = contactInfo;
	}
}
