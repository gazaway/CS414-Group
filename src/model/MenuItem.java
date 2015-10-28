package model;

import java.text.NumberFormat;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class MenuItem {
	
	private DoubleProperty price;
	private StringProperty name;
	private StringProperty description;
	
	public MenuItem(double price_, String name_, String desc_){
		price = new SimpleDoubleProperty();
		name = new SimpleStringProperty();
		description = new SimpleStringProperty();
		this.setPrice(price_);
		this.setName(name_);
		this.setDesc(desc_);
	}

	public String getDesc() {
		return description.get();
	}

	public void setDesc(String description) {
//		this.description = description;
		this.description.set(description);
	}
	
	public StringProperty descProperty(){
		return description;
	}

	public String getName() {
		return name.get();
	}

	public void setName(String name) {
//		this.name = name;
		this.name.set(name);
	}
	
	public StringProperty nameProperty(){
		return name;
	}

	public final double getPrice() {
		return price.get();
	}
	
	public final DoubleProperty getPriceProperty(){
		return price;
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
