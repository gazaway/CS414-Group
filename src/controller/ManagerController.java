package controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import model.ManagerMenuItemCell;
import model.MenuItem;

import java.awt.*;

public class ManagerController {

    @FXML
    private TextField nameField;

    @FXML
    private TextField priceField;

    @FXML
    private TextField descriptionField;

    @FXML
    private ListView<MenuItem> menuList;
    

    private ObservableList<MenuItem> menuItems;

    private static ManagerController instance;

    private ManagerController() {
    	menuItems = PizzaSystem.getInstance().getPizzaStore().getMenu().getMenuItems();
//    	MENU HAS AN OBSERVABLE LIST CALLED ITEMS... USE MANAGER INTERFACE TO GET IT
    }

    public static ManagerController getInstance() {
        if(null == instance) {
            instance = new ManagerController();
        }
        return instance;
    }

    @FXML
    protected void initialize() {
        menuList.setCellFactory(param -> new ManagerMenuItemCell());
        menuList.setItems(PizzaSystem.getInstance().getPizzaStore().getMenu().getMenuItems());
    }

    public ObservableList<MenuItem> getMenuItems() {
        return PizzaSystem.getInstance().getPizzaStore().getMenu().getMenuItems();
    }

    public void removeMenuItem(MenuItem item) {
    	PizzaSystem.getInstance().getPizzaStore().getMenu().getMenuItems().remove(item);
    }

    public void addMenuItem(MenuItem item){
//    	PizzaSystem.getInstance().getPizzaStore().getMenu().getMenuItems().add(item);
    	menuItems.add(item);
    }

    @FXML
    protected void handleAdd(ActionEvent event) {
        nameField.requestFocus();
    }

    @FXML
    protected void handleSave(ActionEvent event) {
    }
}
