package model;

public class Special {
	
	private MenuItem item;
	private PizzaSize size;
	private String specialName;
	private double price;
	
	public Special(String name){
		price = 0;
		this.item = null;
		this.size = null;
		specialName = name;
	}
	
	public void addItemToSpecial(MenuItem item, double price){
		this.price = price;
		item.setPrice(price);
		this.item = item;
	}
	
	public void addPizzaToSpecial(PizzaSize size, double price){
		this.price = price;
		size.setPrice(price);
		this.size = size;
	}
	
	public String getSpecialName(){
		return this.specialName;
	}
	
	public PizzaSize getSize(){
		return size;
	}

	public MenuItem getItem() {
		return item;
	}
	
	public double getSpecialPrice(){
		return this.price;
	}
	
	public void setSpecialPrice(double price){
		this.price = price;
	}
	
	public void removeItemFromSpecial(){
		this.item = null;
	}

	public void removePizzaSizeFromSpecial(){
		this.size = null;
	}
}
