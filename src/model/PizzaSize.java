package model;

public enum PizzaSize {
	SMALL(7.00, "small"), MEDIUM(9.00, "medium"), LARGE(11.00, "large"), EXTRALARGE(13.00, "extra large");
	
	private final double cost;
	private final String desc;
	
	PizzaSize(double cost, String desc){
		this.cost = cost;
		this.desc = desc;
	}
	
	public double getCost(){
		return this.cost;
	}
	
	public String getDesc(){
		return this.desc;
	}
}
