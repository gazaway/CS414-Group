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

public class CustomerMenuItemController {

    private MenuItem item;

    @FXML
    private Parent root;

    @FXML
    private Label priceLabel;

    @FXML
    private Label nameLabel;

    @FXML
    private Label descriptionLabel;

    private static Locale currentLocale = new Locale.Builder().setLanguage("en").setRegion("US").build();

    public Parent getRoot() {
        return root;
    }

    public void setMenuItem(MenuItem item) {
        this.item = item;
        priceLabel.textProperty().bindBidirectional(item.formattedPriceProperty());
        descriptionLabel.textProperty().bindBidirectional(item.descProperty());
        nameLabel.textProperty().bindBidirectional(item.nameProperty());
    }

    @FXML
    protected void handleAddToCart(ActionEvent event) {
        CustomerController.getInstance().addOrderItem(item);
    }
}