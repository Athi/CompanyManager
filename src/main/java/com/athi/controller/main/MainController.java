package com.athi.controller.main;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Athi
 */
public class MainController implements Initializable {

    @FXML
    private Label closeLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        closeLabel.setOnMouseClicked(event -> Platform.exit());
    }
}
