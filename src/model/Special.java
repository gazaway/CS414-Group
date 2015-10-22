package model;

public class Special {
	
	private MenuItem item;
	private PizzaSize size;
	private String specialName;
	
	public Special(String name){
		this.item = null;
		this.size = null;
		specialName = name;
	}
	
	public void addItemToSpecial(MenuItem item, double price){
		item.setPrice(price);
		this.item = item;
	}
	
	public void addPizzaToSpecial(PizzaSize size, double price){
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
	
	public void removeItemFromSpecial(){
		this.item = null;
	}

	public void removePizzaSizeFromSpecial(){
		this.size = null;
	}
}
