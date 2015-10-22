package view;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import controller.ManagerInterface;
import controller.PizzaSystem;

public class Terminator extends WindowAdapter {
	
	private PizzaSystem parentSystem;
	
	public Terminator(PizzaSystem pizzaSystem){
		this.parentSystem = pizzaSystem;
	}
	public void windowClosing(WindowEvent e){
		parentSystem.getPizzaStore().getMenu().saveMenuToFile();
		System.exit(0);
	}
}
