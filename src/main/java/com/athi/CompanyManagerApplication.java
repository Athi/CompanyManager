package com.athi;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.Optional;

import static com.athi.util.FXMLDefinitionImpl.WELCOME;

/**
 * Created by Athi
 */
public class CompanyManagerApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Optional fxml = WELCOME.load();
        if (fxml.isPresent()) {
            Parent root = (Parent) fxml.get();
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
