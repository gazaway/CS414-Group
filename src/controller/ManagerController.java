package controller;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;

public class ManagerController {

    private static ManagerController instance;

    private ManagerController() {
    }

    public static ManagerController getInstance() {
        if(null == instance) {
            instance = new ManagerController();
        }
        return instance;
    }
}
