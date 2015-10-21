package model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

	private final String MENU_FILE_LOCATION;
	private List<MenuItem> items;
	private List<PizzaTopping> pizzaToppings;
	private List<PizzaSize> pizzaSizes;
	
	public Menu(){
		MENU_FILE_LOCATION = "menuFile.cfg";
		this.items = new ArrayList<MenuItem>();
		this.pizzaToppings = new ArrayList<PizzaTopping>();
	}
	
	public Menu loadMenuFromFile(){
		Menu temp = new Menu();
		File file = new File(MENU_FILE_LOCATION);
		Scanner scan;
		try {
			scan = new Scanner(file);
			String text = "";
			while (scan.hasNext()){
				while (!text.equals("!END PIZZA SIZES!")){
					text = scan.nextLine();
					String[] data = text.split(",");
					PizzaSize tempSize = new PizzaSize(Long.valueOf(data[1]), data[0]);
					pizzaSizes.add(tempSize);
				}
				while (!text.equals("!END PIZZA TOPPINGS!")){
					text = scan.nextLine();
					String[] data = text.split(",");
					PizzaTopping tempTop = new PizzaTopping(data[0], data[1]);
					pizzaToppings.add(tempTop);
				}
				while (!text.equals("!END MENU ITEMS!")){
					text = scan.nextLine();
					String[] data = text.split(",");
					MenuItem tempItem = new MenuItem(Long.valueOf(data[2]), data[0], data[1]);
					items.add(tempItem);
				}	
			}
			scan.close();
		} catch (Exception e){
			e.printStackTrace();
		}
		return temp;
	}
	
	public List<MenuItem> getMenuItems(){
		return this.items;
	}
	
	public List<PizzaTopping> getPizzaToppings(){
		return this.pizzaToppings;
	}
	
	@Override
	public String toString(){
		String temp = "";
		temp += "Available Pizza Sizes and Price:";
		for (PizzaSize ps : this.getPizzaSizes()){
			temp += "     Size: " + ps.getDesc() + "  Price: $" + ps.getCost() + '\n';
		}
		temp += '\n' + "Available Pizza Toppings:";
		for (PizzaTopping pt : this.getPizzaToppings()){
			temp += "     " + pt.getName() + '\n';
		}
		temp += '\n' + "Available Menu Items:";
		for (MenuItem mi : this.getMenuItems()){
			temp += "     " + mi.getName() + "  Price: $" + mi.getPrice() + '\n';
		}
		return temp;
	}

	public List<PizzaSize> getPizzaSizes() {
		return this.pizzaSizes;
	}
}
