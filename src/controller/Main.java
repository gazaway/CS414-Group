package controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private Stage customerStage;
    private Stage managerStage;
    private Stage cookStage;

    private static final String CUST_STAGE_TITLE = "Mario Brother's Pizza.";
    private static final String MAN_STAGE_TITLE = "Mario Brothers Pizza (Manager Interface).";
    private static final String COOK_STAGE_TITLE = "Mario Brother's Pizza (Cook Interface).";

    public void run(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws RuntimeException {
        customerStage = stage;
        managerStage = new Stage();
        cookStage = new Stage();

        startStage(customerStage, CUST_STAGE_TITLE, "/view/CustomerView.fxml");
        startStage(managerStage, MAN_STAGE_TITLE, "/view/ManagerView.fxml");
        startStage(cookStage, COOK_STAGE_TITLE, "/view/CookView.fxml");

        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        managerStage.setX(0.0);
        managerStage.setY((screenBounds.getHeight() - managerStage.getHeight()) / 2);
        cookStage.setX(screenBounds.getWidth() - cookStage.getWidth());
        cookStage.setY((screenBounds.getHeight() - cookStage.getHeight()) / 2);
        customerStage.setX((screenBounds.getWidth() - customerStage.getWidth()) / 2);
        customerStage.setY((screenBounds.getHeight() - customerStage.getHeight()) / 2);
    }

    private void startStage(Stage stage, String stageTitle, String viewFile) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(viewFile));
            loader.setController(CustomerController.getInstance());
            Parent root = (Parent) loader.load();
            final Scene scene = new Scene(root, 500.0, 500.0);
            stage.setTitle(stageTitle);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
