package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import model.MenuItem;
import model.CustomerMenuItemCell;

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
    	menuItems = FXCollections.observableArrayList();
    	for(MenuItem temp : PizzaSystem.getInstance().getPizzaStore().getMenu().getMenuItems()){
    		menuItems.add(temp);
    	}
    }

    public static ManagerController getInstance() {
        if(null == instance) {
            instance = new ManagerController();
        }
        return instance;
    }

    @FXML
    protected void initialize() {
        menuList.setCellFactory(param -> new CustomerMenuItemCell());
        menuList.setItems(menuItems);
    }

    public ObservableList<MenuItem> getMenuItems() {
        return menuItems;
    }

    @FXML
    protected void handleAdd(ActionEvent event) {
        nameField.requestFocus();
    }

    @FXML
    protected void handleSave(ActionEvent event) {
    }

    @FXML
    protected void handleCancel(ActionEvent event) {
        nameField.setText("");
        priceField.setText("");
        descriptionField.setText("");
    }
}
