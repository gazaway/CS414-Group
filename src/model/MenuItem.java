package model;

public class MenuItem {
	
	private double price;
	private String name;
	private String desc;
	
	public MenuItem(double price_, String name_, String desc_){
		this.setPrice(price_);
		this.setName(name_);
		this.setDesc(desc_);
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		if (price >= 0){
			this.price = price;
		}
	}

}
