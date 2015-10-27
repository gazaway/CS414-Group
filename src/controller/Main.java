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

    private Scene customerScene;
    private Scene managerScene;
    private Scene cookScene;

    private static final double SCENE_WIDTH = 500.0;
    private static final double SCENE_HEIGHT = 500.0;

    private static final String CUST_STAGE_TITLE = "Mario Brother's Pizza.";
    private static final String MAN_STAGE_TITLE = "Mario Brothers Pizza (Manager Interface).";
    private static final String COOK_STAGE_TITLE = "Mario Brother's Pizza (Cook Interface).";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws RuntimeException {
        customerStage = stage;
        managerStage = new Stage();
        cookStage = new Stage();

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/CustomerView.fxml"));
            loader.setController(CustomerController.getInstance());
            Parent root = (Parent) loader.load();
            customerScene = new Scene(root, SCENE_WIDTH, SCENE_HEIGHT);
            customerStage.setTitle(CUST_STAGE_TITLE);
            customerStage.setScene(customerScene);
            customerStage.show();

            loader = new FXMLLoader(getClass().getResource("/view/ManagerView.fxml"));
            loader.setController(ManagerController.getInstance());
            root = (Parent) loader.load();
            managerScene = new Scene(root, SCENE_WIDTH, SCENE_HEIGHT);
            managerStage.setTitle(MAN_STAGE_TITLE);
            managerStage.setScene(managerScene);
            managerStage.show();

            loader = new FXMLLoader(getClass().getResource("/view/CookView.fxml"));
            loader.setController(CookController.getInstance());
            root = (Parent) loader.load();
            cookScene = new Scene(root, SCENE_WIDTH, SCENE_HEIGHT);
            cookStage.setTitle(COOK_STAGE_TITLE);
            cookStage.setScene(cookScene);
            cookStage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        managerStage.setX(0.0);
        managerStage.setY((screenBounds.getHeight() - managerStage.getHeight()) / 2);
        cookStage.setX(screenBounds.getWidth() - cookStage.getWidth());
        cookStage.setY((screenBounds.getHeight() - cookStage.getHeight()) / 2);
        customerStage.setX((screenBounds.getWidth() - customerStage.getWidth()) / 2);
        customerStage.setY((screenBounds.getHeight() - customerStage.getHeight()) / 2);
    }
}
