package model;

import java.text.NumberFormat;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class MenuItem {
	
	private DoubleProperty price;
	private String name;
	private String description;
	
	public MenuItem(double price_, String name_, String desc_){
		price = new SimpleDoubleProperty();
		this.setPrice(price_);
		this.setName(name_);
		this.setDesc(desc_);
	}

	public String getDesc() {
		return description;
	}

	public void setDesc(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public final double getPrice() {
		return price.get();
	}

	public final void setPrice(double price) {
		if (price >= 0){
			this.price.set(price);
		}
	}

	/*
	 * Equals overrides are needed so we can use pre-made containers that use .contains
	 */
	@Override
	public int hashCode(){
		int hash = 7;
		hash = 31 * hash + (description == null ? 0 : this.getDesc().hashCode());
		hash = 31 * hash + (name == null ? 0 : this.getName().hashCode());
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
		MenuItem mi = (MenuItem)o;
		return (getName().equals(mi.getName()) && (getDesc().equals(mi.getDesc())));
	}
	
	@Override
	public String toString(){
		String temp = "";
		NumberFormat form = NumberFormat.getCurrencyInstance();
		String price = form.format(this.getPrice());
		temp += this.getName() + '\n';
		return temp;
	}
}
