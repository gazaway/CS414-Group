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
	
	/*
	 * Equals overrides are needed so we can use pre-made containers that use .contains
	 */
	@Override
	public int hashCode(){
		int hash = 7;
		hash = 31 * hash + (name == null ? 0 : this.getName().hashCode());
		hash = 31 * hash + (address == null ? 0 : this.getAddress().hashCode());
		hash = 31 * hash + (phone == null ? 0 : this.getPhone().hashCode());
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
		ContactInfo c = (ContactInfo)o;
		return ((this.getAddress().equals(c.getAddress())) && (this.getName().equals(c.getName())) && (this.getPhone().equals(c.getPhone())));
	}
}