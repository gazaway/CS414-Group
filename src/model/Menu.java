package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Menu {

	private Map<MenuItem, Long> items;
	private List<PizzaTopping> pizzaToppings;
	
	public Menu(){
		this.items = new HashMap<MenuItem, Long>();
		this.pizzaToppings = new ArrayList<PizzaTopping>();
	}
	
	public Menu loadMenuFromFile(){
		Menu temp = new Menu();
		return temp;
	}
	
	public Map<MenuItem, Long> getMenuItems(){
		return this.items;
	}
	
	public List<PizzaTopping> getPizzaToppings(){
		return this.pizzaToppings;
	}
}
