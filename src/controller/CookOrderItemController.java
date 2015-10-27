package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import model.MenuItem;

public class CookOrderItemController {

    private MenuItem item;

    @FXML
    private Parent root;

    @FXML
    private Label nameLabel;

    @FXML
    private Button removeFromCartButton;

    public void setMenuItem(MenuItem item) {
        this.item = item;
        nameLabel.setText(item.getName());
    }

    public Parent getRoot() {
        return root;
    }

    @FXML
    protected void handleRemoveFromCart(ActionEvent event) {
        CustomerController.getInstance().removeOrderItem(item);
    }
}
