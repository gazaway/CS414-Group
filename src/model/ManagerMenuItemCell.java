package model;

import controller.CustomerMenuItemController;
import controller.ManagerMenuItemController;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;

import java.io.IOException;

public class ManagerMenuItemCell extends ListCell<MenuItem> {

    private ManagerMenuItemController controller;

    public ManagerMenuItemCell() throws RuntimeException {
        super();
        try {
            controller = new ManagerMenuItemController();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/ManagerMenuItemView.fxml"));
            loader.setController(controller);
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void updateItem(MenuItem item, boolean empty) {
        super.updateItem(item, empty);

        if(!empty && null != item) {
            controller.setMenuItem(item);
        }

        this.setText(null);
        if (empty) {
            this.setGraphic(null);
        } else {
            this.setGraphic(controller.getRoot());
        }
    }
}
