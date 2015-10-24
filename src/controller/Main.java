package controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    public  void run(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws RuntimeException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/MainView.fxml"));
            loader.setController(ViewController.getInstance());
            Parent root = (Parent) loader.load();
            Scene scene = new Scene(root, 600.0, 600.0);
            stage.setTitle("Mario Brothers Pizza");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
