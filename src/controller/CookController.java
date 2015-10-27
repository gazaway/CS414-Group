package controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import model.CookOrderItemCell;
import model.MenuItem;

public class CookController {

    @FXML
    private ListView orderList;

    private ObservableList<MenuItem> orderItems;

    private static CookController instance;

    private CookController() {
        orderItems = CustomerController.getInstance().getOrderItems();
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
        orderList.setItems(orderItems);
    }

    @FXML
    protected void handlePrepareOrder(ActionEvent event) {
    }

    @FXML
    protected void handleCancelOrder(ActionEvent event) {
    }
}
