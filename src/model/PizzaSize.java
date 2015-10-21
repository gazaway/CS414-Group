package model;

public enum PizzaSize {
	SMALL((long)7.00, "SMALL"), MEDIUM((long)9.00, "MEDIUM"), LARGE((long)11.00, "LARGE"), EXTRALARGE((long)13.00, "EXTRA LARGE");
	
	private final long cost;
	private final String desc;
	
	PizzaSize(long cost, String desc){
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
