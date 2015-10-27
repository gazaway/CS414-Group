package controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private Stage customerStage;
    private Stage managerStage;
    private Stage cookStage;

    private static final String CUST_STAGE_TITLE = "Mario Brother's Pizza.";
    private static final String MAN_STAGE_TITLE = "Mario Brothers Pizza (Manager Interface).";
    private static final String COOK_STAGE_TITLE = "Mario Brother's Pizza (Cook Interface).";

    private PizzaSystem system;

    public void run(String[] args) {
        system = new PizzaSystem();
        launch(args);
    }

    @Override
    public void start(Stage stage) throws RuntimeException {

    }

    private void startCustomerStage() {
        customerStage = new Stage();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/CustomerView.fxml"));
            loader.setController(CustomerController.getInstance());
            Parent root = (Parent) loader.load();
            Scene scene = new Scene(root, 600.0, 600.0);
            customerStage.setTitle(CUST_STAGE_TITLE);
            customerStage.setScene(scene);
            customerStage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void startManagerStage() {
        managerStage = new Stage();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/ManagerView.fxml"));
            loader.setController(ManagerController.getInstance());
            Parent root = (Parent) loader.load();
            Scene scene = new Scene(root, 600.0, 600.0);
            managerStage.setTitle(MAN_STAGE_TITLE);
            managerStage.setScene(scene);
            managerStage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        managerStage.setScene(new Scene(new Group(), 260, 230, Color.LIGHTCYAN));
        managerStage.show();
    }

    private void startCookStage() {

    }
}
