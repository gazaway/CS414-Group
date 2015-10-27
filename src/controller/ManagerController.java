package controller;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import model.MenuItem;

import java.awt.*;

public class ManagerController {

    @FXML
    private TextField nameField;

    @FXML
    private TextField priceField;

    @FXML
    private TextField descriptionField;

    private static ManagerController instance;

    private ManagerController() {
    }

    public static ManagerController getInstance() {
        if(null == instance) {
            instance = new ManagerController();
        }
        return instance;
    }

    @FXML
    protected void handleAdd(ActionEvent event) {
        nameField.requestFocus();
    }

    @FXML
    protected void handleSave(ActionEvent event) {
    }

    @FXML
    protected void handleCancel(ActionEvent event) {
        nameField.setText("");
        priceField.setText("");
        descriptionField.setText("");
    }
}
