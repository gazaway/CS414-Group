package controller;

import model.*;

public class ManagerInterface {
	
	private PizzaSystem parentSystem;
	
	public ManagerInterface(PizzaSystem system) {
		this.parentSystem = system;
	}


	public Menu createNewMenu(){
		return new Menu();
	}
	
	
	/*
	 * THE MENU USES A HASHMAP<MenuItem, Double> AS ITS CONTAINER
	 */
	public void addItemToMenu(Long price, String name, String desc){
		MenuItem temp = new MenuItem(price, name, desc);
		parentSystem.getPizzaStore().getMenu().getMenuItems().put(temp, price);
	}
	
	public void removeitemFromMenu(MenuItem item){
		if(parentSystem.getPizzaStore().getMenu().getMenuItems().containsKey(item)){
			parentSystem.getPizzaStore().getMenu().getMenuItems().remove(item);
		}
	}
}
