package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Menu {

	private Map<MenuItem, Double> items;
	private ArrayList<PizzaTopping> pizzaToppings;
	
	public Menu(){
		this.items = new HashMap<MenuItem, Double>();
		this.pizzaToppings = new ArrayList<PizzaTopping>();
	}
	
	public Map<MenuItem, Double> getMenuItems(){
		return this.items;
	}
	
	public ArrayList<PizzaTopping> getPizzaToppings(){
		return this.pizzaToppings;
	}
}
