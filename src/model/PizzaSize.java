package model;

public class PizzaSize {
	
	private final long cost;
	private final String desc;
	
	public PizzaSize(long cost, String desc){
		this.cost = cost;
		this.desc = desc;
	}
	
	public long getCost(){
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
