package com.athi.util;

import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Optional;

/**
 * Created by mp2.
 */
public enum Stylesheets {
    NOTIFICATION("styles/css/notification/notification.css");

    private final String stylePath;

    Stylesheets(String stylePath) {
        this.stylePath = stylePath;
    }

    public void style(Stage stage) {
        Optional.ofNullable(stage.getScene()).ifPresent(this::style);
    }

    public void style(Scene scene) {
        URL styleUrl = Thread.currentThread().getContextClassLoader().getResource("styles/css/notification/notification.css");
        Optional.ofNullable(styleUrl).ifPresent(url -> scene.getStylesheets().add(url.toExternalForm()));
    }
}
