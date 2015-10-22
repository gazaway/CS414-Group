package controller;

import java.util.ArrayList;

import view.CookView;
import model.*;

public class PizzaSystem {
	
	private PizzaStore pizzaStore;
	private OrderInterface orderInterface;
	private ManagerInterface managerInterface;
	private CookView cv;
	
	public PizzaSystem(){
		pizzaStore = new PizzaStore(this);
		orderInterface = new OrderInterface(this);
		managerInterface = new ManagerInterface(this);
		cv = new CookView(this);
		cv.start();
	}
	
	public PizzaStore getPizzaStore(){
		return pizzaStore;
	}
	
	public CookView getCookView(){
		return this.cv;
	}
	
	@Override
	public String toString(){
		String temp = "";
		temp += "The pizza store has " + getPizzaStore().getOrderQueue().getCurrentOrders().size() + " current orders waiting to be made." + '\n';
		temp += "There are " + getPizzaStore().getOrderQueue().getOrdersBeingMade().size() + " orders being made right now." + '\n';
		temp += "This store has fulfilled " + getPizzaStore().getOrderQueue().getPastOrders().size() + " orders total in the past." + '\n';
		temp += "LIST OF ORDERS WAITING TO BE MADE:" + '\n';
		temp += "----------------------------------" + '\n';
		if (getPizzaStore().getOrderQueue().getCurrentOrders().isEmpty()){
			temp += "[NO ORDERS]" + '\n' + '\n';
		}
		else {
			for (Order o : getPizzaStore().getOrderQueue().getCurrentOrders()){
				temp += o.toString() + '\n';
			}
		}
		temp += "LIST OF ORDERS CURRENTLY BEING MADE:" + '\n';
		temp += "------------------------------------" + '\n';
		if (getPizzaStore().getOrderQueue().getOrdersBeingMade().isEmpty()){
			temp += "[NO ORDERS]" + '\n' + '\n';
		}
		else {
			for (Order o : getPizzaStore().getOrderQueue().getOrdersBeingMade()){
				temp += o.toString() + '\n';
			}
		}
		return temp;
	}
	
	public OrderInterface getOrderInterface() {
		return orderInterface;
	}
	
	public ManagerInterface getManagerInterface() {
		return managerInterface;
	}
	
	/*
	 * This is a test run main. In reality, we should be creating an instance of our GUI and making it run.
	 * But this will work for now.
	 */
	public static void main(String[]args){
		//PRINT SYSTEM IN DEFAULT (makes sure all constructors work, etc)
		PizzaSystem test = new PizzaSystem();
		//System.out.println(test);
		//CREATE A NEW ORDER, ADD IT INTO QUEUE, PRINT SYSTEM
		PizzaTopping[] pt = { new PizzaTopping("Ham", "") , new PizzaTopping("Bacon", "") , new PizzaTopping("Pineapple", "") };
		ArrayList<Pizza> pizzas = new ArrayList<Pizza>();
		pizzas.add(new Pizza(pt, new PizzaSize((long)7, "SMALL")));
		Order testOrder = test.getOrderInterface().createNewOrder(new ArrayList<MenuItem>(), pizzas);
		//System.out.println("~!~!~!~!~!~!~!~!~!~!~!~!~! ORDER HAS BEEN CREATED NOW ~!~!~!~!~!~!~!~!~!~!~!~!~!" + '\n');
		//This would normally be made by grabbing the "checked options" of a combo box. 
		
		//The size would also be part of a drop down/combo box
		test.getOrderInterface().addItemToOrder(testOrder, new MenuItem((long)5.00, "6 pc Buffalo Wings", ""));
		//System.out.println(test);
		//System.out.println("~!~!~!~!~!~!~!~!~!~!~!~!~! ORDER HAS BEEN MOVED NOW ~!~!~!~!~!~!~!~!~!~!~!~!~!" + '\n');
		//THIS SHOULD TAKE THE ORDER OUT OF THE PENDING QUEUE AND PLACE IT IN THE BEING WORKED ON QUEUE
		/*System.out.println(test.getPizzaStore().getMenu());
		test.getPizzaStore().getMenu().loadMenuFromFile();
		System.out.println();
		test.getManagerInterface().addItemToMenu((long)8, "Chicken Poppers", "Not good for you");
		System.out.println(test.getPizzaStore().getMenu());
		test.getPizzaStore().getMenu().saveMenuToFile();*/
	}
}
