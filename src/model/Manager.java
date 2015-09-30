package model;

public class Manager extends Cashier{

	public Manager(String name, String address, String phone) {
		super(name, address, phone);
	}
	
	public Manager(Cashier cashier) {
		super(cashier.getContactInfo());
	}
}
