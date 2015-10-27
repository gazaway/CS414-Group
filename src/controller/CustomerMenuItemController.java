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

    @FXML
    private Button addToCartButton;

    private static Locale currentLocale = new Locale.Builder().setLanguage("en").setRegion("US").build();

    public Parent getRoot() {
        return root;
    }

    public void setMenuItem(MenuItem item) {
        this.item = item;
        Currency currentCurrency = Currency.getInstance(currentLocale);
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(currentLocale);
        priceLabel.setText(currencyFormatter.format(item.getPrice()));
        nameLabel.setText(item.getName());
        descriptionLabel.setText(item.getDesc());
    }

    @FXML
    protected void handleAddToCart(ActionEvent event) {
        CustomerController.getInstance().addOrderItem(item);
    }
}