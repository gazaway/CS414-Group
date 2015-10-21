package controller;

import model.*;

public class ManagerInterface {
	
	private System parentSystem;
	
	public Menu createNewMenu(System system){
		this.parentSystem = system;
		return new Menu();
	}
	
	
	/*
	 * THE MENU USES A HASHMAP<MenuItem, Double> AS ITS CONTAINER
	 */
	public void addItemToMenu(double price, String name, String desc){
		MenuItem temp = new MenuItem(price, name, desc);
		parentSystem.getStore().getMenu().getMenuItems().put(temp, price);
	}
}
