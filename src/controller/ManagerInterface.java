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
	
	public void clearWholeMenu(){
		parentSystem.getPizzaStore().setMenu(new Menu());
	}

	public Special createSpecialWithItem(String name, MenuItem item, double price){
		Special temp = new Special(name);
		temp.addItemToSpecial(item, price);
		parentSystem.getPizzaStore().getSpecials().add(temp);
		return temp;
	}
	
	public Special createSpecialWithPizza(String name, PizzaSize size, double price){
		Special temp = new Special(name);
		temp.addPizzaToSpecial(size, price);
		parentSystem.getPizzaStore().getSpecials().add(temp);
		return temp;
	}
	
	public Special addItemToSpecial(Special special, MenuItem item, double price){
		if (special.getItem() == null){
			item.setPrice(price);
			special.addItemToSpecial(item, price);
			return special;
		}
		else {
			Special temp = new Special("Will get from GUI");
			temp.addItemToSpecial(item, price);
			//TODO GUI POPUP giving options for making a new special
			//make the special using createSpecialWithPizza.
			return temp;
		}
	}
	
	public void removeItemFromSpecial(Special special){
		special.removeItemFromSpecial();
	}
	
	public Special addPizzaToSpecial(Special special, PizzaSize size, double price){
		if (special.getSize() == null){
			size.setPrice(price);
			special.addPizzaToSpecial(size, price);
			return special;
		}
		else {
			Special temp = new Special("WILL GET FROM GUI");
			temp.addPizzaToSpecial(size, price);
			//TODO GUI POPUP giving options for making a new special
			//make the special using createSpecialWithPizza.
			return temp;
			
		}
	}
	
	public void removePizzaFromSpecial(Special special){
		special.removePizzaSizeFromSpecial();
	}
	
	public MenuItem addItemToMenu(double price, String name, String desc){
		MenuItem temp = new MenuItem(price, name, desc);
		if (!parentSystem.getPizzaStore().getMenu().getMenuItems().contains(temp)){
			parentSystem.getPizzaStore().getMenu().getMenuItems().add(temp);
			return temp;
		}
		else {
			try {
				throw new PizzaException("Item being added to menu is already in system.");
			} catch (PizzaException e) {
			}
			return null;
		}
	}
	
	public void removeItemFromMenu(MenuItem item){
		if(parentSystem.getPizzaStore().getMenu().getMenuItems().contains(item)){
			parentSystem.getPizzaStore().getMenu().getMenuItems().remove(item);
		}
	}
	
	public PizzaSize addPizzaSizeToMenu(double price, String desc){
		PizzaSize temp = new PizzaSize(price, desc);
		if (!parentSystem.getPizzaStore().getMenu().getPizzaSizes().contains(temp)){
			parentSystem.getPizzaStore().getMenu().getPizzaSizes().add(temp);
			return temp;
		}
		else {
			try {
				throw new PizzaException("Pizza size already in system.");
			} catch (PizzaException e) {
			}
			return null;
		}
	}
	
	public void removePizzaSizeFromMenu(PizzaSize ps){
		if (parentSystem.getPizzaStore().getMenu().getPizzaSizes().contains(ps)){
			parentSystem.getPizzaStore().getMenu().getPizzaSizes().remove(ps);
		}
	}
		
	public PizzaTopping addPizzaToppingToMenu(String name, String desc){
		PizzaTopping temp = new PizzaTopping(name, desc);
		if (parentSystem.getPizzaStore().getMenu().getPizzaToppings().contains(temp)){
			removePizzaToppingFromMenu(temp);
		}
		parentSystem.getPizzaStore().getMenu().getPizzaToppings().add(temp);
		return temp;
	}
	
	public void removePizzaToppingFromMenu(PizzaTopping pt){
		parentSystem.getPizzaStore().getMenu().getPizzaToppings().remove(pt);
	}
}
