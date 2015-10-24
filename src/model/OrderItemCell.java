package model;

import controller.MenuItemController;
import controller.OrderItemController;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;

import java.io.IOException;

public class OrderItemCell extends ListCell<MenuItem> {
    private OrderItemController orderItemController;

    public OrderItemCell() throws RuntimeException {
        super();
        try {
            orderItemController = new OrderItemController();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/OrderItemView.fxml"));
            loader.setController(orderItemController);
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void updateItem(MenuItem item, boolean empty) {
        super.updateItem(item, empty);

        if(!empty && null != item) {
            orderItemController.setMenuItem(item);
        }

        this.setText(null);
        if (empty) {
            this.setGraphic(null);
        } else {
            this.setGraphic(orderItemController.getRoot());
        }
    }
}
