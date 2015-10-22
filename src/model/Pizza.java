package model;

import java.text.NumberFormat;

public class Pizza {

	private final double PER_TOPPING_PRICE = 0.99;
	private PizzaTopping[] toppings;
	private PizzaSize size;
	private double price;
	
	public Pizza(PizzaTopping[] toppings, PizzaSize size){
		this.toppings = toppings;
		this.size = size;
		determinePrice();
	}

	private double determinePrice() {
		long sum = 0;
		sum += size.getPrice();
		sum += ((toppings.length - 1) * PER_TOPPING_PRICE);
		this.setPrice(sum);
		return sum;
	}

	public PizzaTopping[] getToppings() {
		return toppings;
	}

	public void setToppings(PizzaTopping[] toppings) {
		this.toppings = toppings;
	}

	public PizzaSize getSize() {
		return size;
	}

	public void setSize(PizzaSize size) {
		this.size = size;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	/*
	 * Example: 
	 * [LARGE PIZZA] : Ham Bacon Pineapple
	 */
	@Override
	public String toString(){
		String temp = "";
		NumberFormat form = NumberFormat.getCurrencyInstance();
		String price = form.format(this.getPrice());
		temp += "[" + this.getSize() + " PIZZA] :";
		for (PizzaTopping pt : this.getToppings()){
			temp += " " + pt.getName();
		}
		temp += " PRICE: " + price + '\n';
		return temp;
	}
	
}
