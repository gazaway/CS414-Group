package model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class MenuItem {
	
	private DoubleProperty price = new SimpleDoubleProperty();
	private StringProperty formattedPrice = new SimpleStringProperty();
	private StringProperty name = new SimpleStringProperty();
	private StringProperty description = new SimpleStringProperty();

	private static final Locale currentLocale = new Locale.Builder().setLanguage("en").setRegion("US").build();
	private static final NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(currentLocale);
	
	public MenuItem(double price_, String name_, String desc_){
		this.setPrice(price_);
		this.setName(name_);
		this.setDesc(desc_);
	}

	public String getDesc() {
		return description.get();
	}

	public void setDesc(String description) {
		this.description.setValue(description);
	}

	public final StringProperty descProperty() { return this.description; }

	public String getName() {
		return name.get();
	}

	public void setName(String name) {
		this.name.setValue(name);
	}

	public final StringProperty nameProperty() { return name; }

	public final double getPrice() {
		return price.get();
	}

	public final void setPrice(double price) {
		if (price >= 0){
			this.price.set(price);
			this.formattedPrice.set(currencyFormatter.format(price));
		}
	}

	public final DoubleProperty priceProperty() { return price; }

	public final String getFormattedPrice() {
		return this.formattedPrice.get();
	}

	public final void setFormattedPrice(String price) throws ParseException {
		this.price.set(currencyFormatter.parse(price).doubleValue());
		this.formattedPrice.set(price);
	}

	public final StringProperty formattedPriceProperty() {
		return formattedPrice;
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
