package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Menu {

	private Map<MenuItem, Double> items;
	private List<PizzaTopping> pizzaToppings;
	
	public Menu(){
		this.items = new HashMap<MenuItem, Double>();
		this.pizzaToppings = new ArrayList<PizzaTopping>();
	}
	
	public Map<MenuItem, Double> getMenuItems(){
		return this.items;
	}
	
	public List<PizzaTopping> getPizzaToppings(){
		return this.pizzaToppings;
	}
}
