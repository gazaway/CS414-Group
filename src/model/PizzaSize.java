package model;

public class PizzaSize {
	
	private double cost;
	private final String desc;
	
	public PizzaSize(double cost, String desc){
		this.cost = cost;
		this.desc = desc;
	}
	
	public double getPrice(){
		return this.cost;
	}
	
	public void setPrice(double price){
		this.cost = price;
	}
	
	public String getDesc(){
		return this.desc;
	}
	
	@Override
	public String toString(){
		return this.getDesc();
	}
}
