package model;

import java.util.ArrayList;
import java.util.List;

public class Special {
	
	private List<MenuItem> items;
	private List<Pizza> pizzas;
	
	public Special(){
		this.items = new ArrayList<MenuItem>();
		this.pizzas = new ArrayList<Pizza>();
	}
	
	public void addItemToSpecial(MenuItem item, double price){
		item.setPrice(price);
		this.items.add(item);
	}
	
	public void addPizzaToSpecial(Pizza pizza, double price){
		pizza.setPrice(price);
		this.pizzas.add(pizza);
	}
	
	public List<Pizza> getPizzas(){
		return pizzas;
	}

	public List<MenuItem> getItems() {
		return items;
	}

}
