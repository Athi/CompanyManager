package com.athi.controller.utils;

import javafx.scene.control.Alert;
import javafx.stage.StageStyle;

import static javafx.scene.control.Alert.AlertType.*;

/**
 * Created by Athi
 */
public class Notification {

    public static void information(String header, String message) {
        Alert alert = createAlert(INFORMATION, message, header);
        alert.showAndWait();
    }

    public static void information(String message) {
        Alert alert = createAlert(INFORMATION, message);
        alert.showAndWait();
    }

    public static void warning(String header, String message) {
        Alert alert = createAlert(WARNING, message, header);
        alert.showAndWait();
    }

    public static void warning(String message) {
        Alert alert = createAlert(WARNING, message);
        alert.showAndWait();
    }

    public static void confirmation(String header, String message) {
        Alert alert = createAlert(CONFIRMATION, message, header);
        alert.showAndWait();
    }

    public static void confirmation(String message) {
        Alert alert = createAlert(CONFIRMATION, message);
        alert.showAndWait();
    }

    public static void error(String header, String message) {
        Alert alert = createAlert(ERROR, message, header);
        alert.showAndWait();
    }

    public static void error(String message) {
        Alert alert = createAlert(ERROR, message);
        alert.showAndWait();
    }

    private static Alert createAlert(Alert.AlertType alertType, String message, String header) {
        Alert alert = createAlert(alertType, message);
        alert.setHeaderText(header);
        return alert;
    }

    private static Alert createAlert(Alert.AlertType alertType, String message) {
        Alert alert = new Alert(alertType, message);
        alert.initStyle(StageStyle.TRANSPARENT);
        alert.setResizable(false);
        alert.getDialogPane().setOnMouseClicked(event -> alert.close());

        String notificationCSS = Thread.currentThread().getContextClassLoader().getResource("styles/css/notification/notification.css").toExternalForm();
        alert.getDialogPane().getStylesheets().add(notificationCSS);
        alert.getDialogPane().getStyleClass().add("errorNotification");
        return alert;
    }


}
