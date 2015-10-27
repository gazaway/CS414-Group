package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import model.MenuItem;

import java.text.NumberFormat;
import java.util.Locale;

public class ManagerMenuItemController {

    private MenuItem item;

    @FXML
    private Parent root;

    @FXML
    private TextField nameField;

    @FXML
    private TextField priceField;

    @FXML
    private TextField descriptionField;

    private static Locale currentLocale = new Locale.Builder().setLanguage("en").setRegion("US").build();

    public Parent getRoot() {
        return root;
    }

    public void setMenuItem(MenuItem item) {
        this.item = item;
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(currentLocale);
        priceField.setText(currencyFormatter.format(item.getPrice()));
        nameField.setText(item.getName());
        descriptionField.setText(item.getDesc());
    }

    @FXML
    protected void handleRemove(ActionEvent event) {
        ManagerController.getInstance().removeMenuItem(item);
    }
}