package controller;

import model.*;

public class System {
	
	private PizzaStore pizzaStore;
	private OrderQueue orderQueue;
	private OrderInterface orderInterface;
	
	public System(){
		pizzaStore = new PizzaStore(this);
		orderQueue = new OrderQueue(this);
		orderInterface = new OrderInterface(this);
	}

	public OrderQueue getOrderQueue() {
		return this.orderQueue;
	}
}
