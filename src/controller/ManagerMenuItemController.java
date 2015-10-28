package controller;

import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;
import javafx.util.converter.NumberStringConverter;
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
        priceField.textProperty().bindBidirectional(item.getPriceProperty());
        nameField.textProperty().bindBidirectional(item.nameProperty());
        descriptionField.textProperty().bindBidirectional(item.descProperty());
    }

    @FXML
    protected void handleRemove(ActionEvent event) {
        ManagerController.getInstance().removeMenuItem(item);
    }

}