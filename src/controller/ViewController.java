package controller;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.util.Callback;
import model.MenuItem;
import model.MenuItemCell;
import model.OrderItemCell;

public class ViewController {

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

    private static ViewController instance;

    private ViewController() {
        menuItems = FXCollections.observableArrayList();
        orderItems = FXCollections.observableArrayList();
        orderItems.addListener((ListChangeListener) change -> checkoutTab.setDisable(orderItems.isEmpty()));
    }

    public static ViewController getInstance() {
        if(null == instance) {
            instance = new ViewController();
        }
        return instance;
    }

    @FXML
    protected void initialize() {
        menuTab.setDisable(false);
        checkoutTab.setDisable(true);
        billingTab.setDisable(true);

        menuList.setCellFactory(param -> new MenuItemCell());
        menuList.setItems(menuItems);

        orderList.setCellFactory(param -> new OrderItemCell());
        orderList.setItems(orderItems);

        MenuItem testItem = new MenuItem(1.00, "Test Name", "Test Descr");
        menuItems.add(testItem);
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