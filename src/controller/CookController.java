package controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import model.CookOrderItemCell;
import model.MenuItem;
import model.PizzaException;

public class CookController {

    @FXML
    private ListView orderList;

//    private ObservableList<MenuItem> currentOrdersNotPrepped;
//    private ObservableList<MenuItem> ordersBeingMade;

    private static CookController instance;

    private CookController() {
    	PizzaSystem.getInstance().getPizzaStore().getOrderQueue().getCurrentOrders(); 
    	PizzaSystem.getInstance().getPizzaStore().getOrderQueue().getOrdersBeingMade();
//    	currentOrdersNotPrepped = CustomerController.getInstance().getOrderItems();
    }

    public static CookController getInstance() {
        if(null == instance) {
            instance = new CookController();
        }
        return instance;
    }

    @FXML
    protected void initialize() {
        orderList.setCellFactory(param -> new CookOrderItemCell());
        orderList.setItems(PizzaSystem.getInstance().getPizzaStore().getOrderQueue().getCurrentOrders());
        orderList.setItems(PizzaSystem.getInstance().getPizzaStore().getOrderQueue().getOrdersBeingMade());
    }

    @FXML
    protected void handlePrepareOrder(ActionEvent event) {
    	try {
			PizzaSystem.getInstance().getOrderInterface().grabNextOrder();
		} catch (PizzaException e) {
			System.out.println("No more items");
		}
    }

    @FXML
    protected void handleCancelOrder(ActionEvent event) {
    	
//    	PizzaSystem.getInstance().getOrderInterface().cancelCurrentOrder();
    }
}
