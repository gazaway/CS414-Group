package model;








public class ContactInfo {
	private String name;
	private String address;
	private String phone;
	
	/*
	 * Constructor for creating contact info when info is known.
	 */
	public ContactInfo(String name, String address, String phone){
		this.name = name;
		this.address = address;
		this.phone = phone;
	}
	
	/*
	 * Default constructor for use with non-logged in customers.
	 */
	public ContactInfo() {
		this.name = "";
		this.address = "";
		this.phone = "";
	}

	public String getName(){ return name; }
	public String getAddress(){ return address;}
	public String getPhone(){ return phone; }
	
	public void setName(String name){ this.name = name; }
	public void setAddress(String address){ this.address = address; }
	public void setPhone(String phone){ this.phone = phone; }
}