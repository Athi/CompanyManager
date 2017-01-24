package com.athi.controller.utils;

import javafx.scene.control.Alert;
import javafx.stage.StageStyle;

/**
 * Created by Athi
 */
public class Notification {

    public static void show(String message, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType, message);
        alert.initStyle(StageStyle.UTILITY);
        alert.showAndWait();
    }

}
