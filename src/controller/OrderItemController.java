package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import model.MenuItem;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

public class OrderItemController {

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
        ViewController.getInstance().removeOrderItem(item);
    }
}
