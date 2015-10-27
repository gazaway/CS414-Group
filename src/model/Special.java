package model;

import javafx.beans.property.DoubleProperty;

public class Special {
	
	private MenuItem item;
	private PizzaSize size;
	private String specialName;
	private DoubleProperty price;
	
	public Special(String name){
		price.set(0  );
		this.item = null;
		this.size = null;
		specialName = name;
	}
	
	public void addItemToSpecial(MenuItem item, double price){
		this.price.set(price);
		item.setPrice(price);
		this.item = item;
	}
	
	public void addPizzaToSpecial(PizzaSize size, double price){
		this.price.set(price);
		size.setPrice(price);
		this.size = size;
	}
	
	public String getSpecialName(){
		return this.specialName;
	}
	
	public void setSpecialName(String name){
		this.specialName = name;
	}
	
	public PizzaSize getSize(){
		return size;
	}

	public MenuItem getItem() {
		return item;
	}
	
	public double getSpecialPrice(){
		return price.get();
	}
	
	public void setSpecialPrice(double price){
		this.price.set(price);
	}
	
	public void removeItemFromSpecial(){
		this.item = null;
	}

	public void removePizzaSizeFromSpecial(){
		this.size = null;
	}

	public boolean hasPizzaSize() {
		return (this.size != null);
	}
	
	public boolean hasItem() {
		return (this.item != null);
	}
	
	/*
	 * Equals overrides are needed so we can use pre-made containers that use .contains
	 */
	@Override
	public int hashCode(){
		int hash = 7;
		hash = 31 * hash + (item == null ? 0 : this.getItem().hashCode());
		hash = 31 * hash + (size == null ? 0 : this.getSize().hashCode());
		hash = 31 * hash + (specialName == null ? 0 : this.getSpecialName().hashCode());
		return hash;
	}
	
	@Override
	public boolean equals(Object o){
		if (this == (o)){
			return true;
		}
		if ((o == null) || (o.getClass() != this.getClass())){
			return false;
		}
		Special c = (Special)o;
		return ((this.getItem().equals(c.getItem())) && (this.getSize().equals(c.getSize())) && (this.getSpecialName().equals(c.getSpecialName())) && (this.price == (c.price)));
	}
}
