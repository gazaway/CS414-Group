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

	public Special createSpecial(){
		return new Special();
	}
	
	public void addItemToSpecial(Special special, MenuItem item, double price){
		boolean present = false;
		for (MenuItem mi : special.getItems()){
			if (item.getName().trim().equalsIgnoreCase(mi.getName().trim())){
				present = true;
				mi.setPrice(price);
			}
		}
		if (!present){
			special.addItemToSpecial(item, price);
		}
	}
	
	public void addItemToMenu(double price, String name, String desc){
		MenuItem temp = new MenuItem(price, name, desc);
		if (!parentSystem.getPizzaStore().getMenu().getMenuItems().contains(temp)){
			parentSystem.getPizzaStore().getMenu().getMenuItems().add(temp);
		}
	}
	
	public void removeItemFromMenu(MenuItem item){
		if(parentSystem.getPizzaStore().getMenu().getMenuItems().contains(item)){
			parentSystem.getPizzaStore().getMenu().getMenuItems().remove(item);
		}
	}
	
	public void removePizzaSizeToMenu(PizzaSize ps){
		if (parentSystem.getPizzaStore().getMenu().getPizzaSizes().contains(ps)){
			parentSystem.getPizzaStore().getMenu().getPizzaSizes().remove(ps);
		}
	}
	
	public void addPizzaSizeToMenu(double price, String desc){
		PizzaSize temp = new PizzaSize(price, desc);
		if (!parentSystem.getPizzaStore().getMenu().getPizzaSizes().contains(temp)){
			parentSystem.getPizzaStore().getMenu().getPizzaSizes().add(temp);
		}
	}
	
	public void addPizzaToppingToMenu(String name, String desc){
		PizzaTopping temp = new PizzaTopping(name, desc);
		
	}
}
