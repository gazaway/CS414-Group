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
	
	@Override
	public int hashCode(){
		int hash = 7;
		hash = 31 * hash + (desc == null ? 0 : this.getDesc().hashCode());
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
		PizzaSize c = (PizzaSize)o;
		return (this.getDesc().trim().equalsIgnoreCase(c.getDesc().trim()));
	}
}
