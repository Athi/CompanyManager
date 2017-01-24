package com.athi;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.net.URL;
import java.util.Objects;

/**
 * Created by Athi
 */
public class CompanyManagerApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        URL welcomeFXMLResource = Thread.currentThread().getContextClassLoader().getResource("com/athi/welcome/welcome.fxml");
        if (Objects.nonNull(welcomeFXMLResource)) {
            Parent root = FXMLLoader.load(welcomeFXMLResource);
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.initStyle(StageStyle.UNDECORATED);
            primaryStage.show();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
