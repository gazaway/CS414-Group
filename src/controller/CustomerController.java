package controller;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import model.MenuItem;
import model.CustomerMenuItemCell;
import model.CustomerOrderItemCell;

public class CustomerController {

    @FXML
    private Tab menuTab;

    @FXML
    private Tab checkoutTab;

    @FXML
    private Tab billingTab;

    @FXML
    private ListView<MenuItem> menuList;

    @FXML
    private ListView<MenuItem> orderList;

    private ObservableList<MenuItem> menuItems;
    private ObservableList<MenuItem> orderItems;

    private static CustomerController instance;

    private CustomerController() {
        menuItems = ManagerController.getInstance().getMenuItems();
        orderItems = FXCollections.observableArrayList();
        orderItems.addListener((ListChangeListener) change -> checkoutTab.setDisable(orderItems.isEmpty()));
    }

    public static CustomerController getInstance() {
        if(null == instance) {
            instance = new CustomerController();
        }
        return instance;
    }

    @FXML
    protected void initialize() {
        menuList.setCellFactory(param -> new CustomerMenuItemCell());
        menuList.setItems(menuItems);

        orderList.setCellFactory(param -> new CustomerOrderItemCell());
        orderList.setItems(orderItems);

        /*
         * this creates a system withing the system.. commenting out...

        //fill menu here
        MenuItem testItem = new MenuItem(1.00, "Test Name", "Test Descr");
        menuItems.add(testItem);
        
        PizzaSystem pizzaSystem = new PizzaSystem();
        // need a menu with items to populate item list
         * 
         */
    }

    public ObservableList<MenuItem> getOrderItems() {
        return orderItems;
    }

    public void addOrderItem(MenuItem orderItem) {
        orderItems.add(orderItem);
    }

    public void removeOrderItem(MenuItem orderItem) {
        orderItems.remove(orderItem);
    }

    @FXML
    protected void handleRemoveFromCart(ActionEvent event) {
        MenuItem selectedItem = orderList.getSelectionModel().getSelectedItem();
        if(null != selectedItem) {
            orderItems.remove(selectedItem);
        }
    }
}