package model;

public enum PizzaSize {
	SMALL(7.00, "SMALL"), MEDIUM(9.00, "MEDIUM"), LARGE(11.00, "LARGE"), EXTRALARGE(13.00, "EXTRA LARGE");
	
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
	
	@Override
	public String toString(){
		return this.getDesc();
	}
}
