package model;

import controller.CustomerOrderItemController;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;

import java.io.IOException;

public class CustomerOrderItemCell extends ListCell<MenuItem> {
    private CustomerOrderItemController customerOrderItemController;

    public CustomerOrderItemCell() throws RuntimeException {
        super();
        try {
            customerOrderItemController = new CustomerOrderItemController();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/CustomerOrderItemView.fxml"));
            loader.setController(customerOrderItemController);
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void updateItem(MenuItem item, boolean empty) {
        super.updateItem(item, empty);
        if(null != item && !empty) {
            customerOrderItemController.setMenuItem(item);
            this.setGraphic(customerOrderItemController.getRoot());
        }
    }
}
