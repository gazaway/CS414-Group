package model;

public class Manager extends Cashier{
	
	private ContactInfo contactInfo;

	public Manager(String name, String address, String phone) {
		super(name, address, phone);
	}
}
