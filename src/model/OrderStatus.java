package model;

public enum OrderStatus {
	canceled ("Canceled"), complete ("Complete"), pending ("Pending"), beingMade ("Being Made"), noneSelected ("None Selected");
	
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
