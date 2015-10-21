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
	public void addItemToMenu(double price, String name, String desc){
		MenuItem temp = new MenuItem((long)price, name, desc);
		parentSystem.getPizzaStore().getMenu().getMenuItems().put(temp, price);
	}
}
