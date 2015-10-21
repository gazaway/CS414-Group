package model;

public class PizzaTopping {
	
	private String name;
	private String desc;
	
	public PizzaTopping(String name, String desc){
		this.name = name;
		this.desc = desc;
	}
	
	public String getName(){
		return this.name;
	}
	
	public String getDesc(){
		return this.desc;
	}

}
