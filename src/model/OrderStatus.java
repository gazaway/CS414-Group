package model;

public enum OrderStatus {
	canceled ("canceled"), complete ("complete"), pending ("pending");
	
	private final String desc;
	
	OrderStatus(String desc){
		this.desc = desc;
	}
	
	public String getDesc(){
		return this.desc;
	}
	
	@Override
	public String toString(){
		return this.getDesc();
	}
}
