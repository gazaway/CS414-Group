package model;

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
		double sum = 0;
		sum += size.getCost();
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
		temp += "[" + this.getSize() + " PIZZA] :";
		for (PizzaTopping pt : this.getToppings()){
			temp += " " + pt.getName();
		}
		temp += '\n';
		return temp;
	}
}
