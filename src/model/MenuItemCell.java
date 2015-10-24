package model;

import controller.MenuItemController;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;

import java.io.IOException;

public class MenuItemCell extends ListCell<MenuItem> {
    private MenuItemController menuItemController;

    public MenuItemCell() throws RuntimeException {
        super();
        try {
            menuItemController = new MenuItemController();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/MenuItemView.fxml"));
            loader.setController(menuItemController);
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void updateItem(MenuItem item, boolean empty) {
        super.updateItem(item, empty);

        if(!empty && null != item) {
            menuItemController.setMenuItem(item);
        }

        this.setText(null);
        if (empty) {
            this.setGraphic(null);
        } else {
            this.setGraphic(menuItemController.getRoot());
        }
    }
}
