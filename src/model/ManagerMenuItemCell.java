package model;

import controller.CustomerMenuItemController;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;

import java.io.IOException;

public class ManagerMenuItemCell extends ListCell<MenuItem> {
    private CustomerMenuItemController customerMenuItemController;

    public ManagerMenuItemCell() throws RuntimeException {
        super();
        try {
            customerMenuItemController = new CustomerMenuItemController();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/ManagerMenuItemView.fxml"));
            loader.setController(customerMenuItemController);
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void updateItem(MenuItem item, boolean empty) {
        super.updateItem(item, empty);

        if(!empty && null != item) {
            customerMenuItemController.setMenuItem(item);
        }

        this.setText(null);
        if (empty) {
            this.setGraphic(null);
        } else {
            this.setGraphic(customerMenuItemController.getRoot());
        }
    }
}
