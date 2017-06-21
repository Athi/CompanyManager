package com.athi.controller.welcome;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import static com.athi.util.FXMLDefinitionImpl.MAIN;

/**
 * Created by Athi
 */
public class WelcomeController implements Initializable {

    @FXML
    private Text welcomeText;

    @FXML
    private Label closeLabel;

    @FXML
    private Button enterButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        closeLabel.setOnMouseClicked(event -> Platform.exit());
    }

    @FXML
    private void enterAction(ActionEvent event) throws Exception { //TODO cos z tym exception???
        Optional fxml = MAIN.load();
        if (fxml.isPresent()) {
            Parent root = (Parent) fxml.get();
            Scene scene = new Scene(root);

            Stage stage = new Stage();
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setResizable(true);
            stage.setMaximized(true);
            stage.setTitle("TEST APPLICATION"); //TODO change
            stage.setScene(scene);
            stage.show();

            Stage oldStage = (Stage) closeLabel.getScene().getWindow();
            oldStage.close();
        }
    }

}
