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
        if(null != item && !empty) {
            controller.setMenuItem(item);
            this.setGraphic(controller.getRoot());
        }
    }
}
