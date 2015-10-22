package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

	private final String MENU_FILE_LOCATION;
	private List<MenuItem> items;
	private List<PizzaTopping> pizzaToppings;
	private List<PizzaSize> pizzaSizes;
	
	public Menu(){
		MENU_FILE_LOCATION = "src/menuFile.cfg";
		this.items = new ArrayList<MenuItem>();
		this.pizzaToppings = new ArrayList<PizzaTopping>();
		this.pizzaSizes = new ArrayList<PizzaSize>();
	}
	
	public Menu loadMenuFromFile(){
		Menu temp = new Menu();
		File file = new File(MENU_FILE_LOCATION);
		Scanner scan;
		try {
			scan = new Scanner(file);
			String text = "";
			while (scan.hasNext()){
				while (!(text = scan.nextLine().trim()).contains("END")){
					String[] data = text.split(",");
					PizzaSize tempSize = new PizzaSize(Double.valueOf(data[1].trim()), data[0].trim());
					pizzaSizes.add(tempSize);
				}
				while (!(text = scan.nextLine().trim()).contains("END")){
					String[] data = text.split(",");
					PizzaTopping tempTop = new PizzaTopping(data[0].trim(), data[1].trim());
					pizzaToppings.add(tempTop);
				}
				while (!(text = scan.nextLine().trim()).contains("END")){
					String[] data = text.split(",");
					MenuItem tempItem = new MenuItem(Double.valueOf(data[2].trim()), data[0].trim(), data[1].trim());
					items.add(tempItem);
				}	
			}
			scan.close();
		} catch (Exception e){
			e.printStackTrace();
		}
		return temp;
	}
	
	public void saveMenuToFile(){
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(new File(MENU_FILE_LOCATION));
			for (PizzaSize ps : getPizzaSizes()){
				writer.write(ps.getDesc() + ", " + ps.getPrice() + '\n');
			}
			writer.println("!END PIZZA SIZES!,");
			for (PizzaTopping pt: getPizzaToppings()){
				writer.println(pt.getName() + ", " + pt.getDesc());
			}
			writer.println("!END PIZZA TOPPINGS!,");
			for (MenuItem mi : getMenuItems()){
				writer.println(mi.getName() + ", " + mi.getDesc() + ", " + mi.getPrice());
			}
			writer.println("!END MENU ITEMS!,");
			writer.flush();
			writer.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
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
		temp += "Available Pizza Sizes and Price:" + '\n';
		NumberFormat form = NumberFormat.getCurrencyInstance();
		String price; 
		for (PizzaSize ps : this.getPizzaSizes()){
			price = form.format(ps.getPrice());
			temp += "     Size: " + ps.getDesc() + "  Price: " + price + '\n';
		}
		temp += '\n' + "Available Pizza Toppings:" + '\n';
		for (PizzaTopping pt : this.getPizzaToppings()){
			temp += "     " + pt.getName() + '\n';
		}
		temp += '\n' + "Available Menu Items:" + '\n';
		for (MenuItem mi : this.getMenuItems()){
			price = form.format(mi.getPrice());
			temp += "     " + mi.getName() + "  Price: " + price + '\n';
		}
		return temp;
	}

	public List<PizzaSize> getPizzaSizes() {
		return this.pizzaSizes;
	}
}
