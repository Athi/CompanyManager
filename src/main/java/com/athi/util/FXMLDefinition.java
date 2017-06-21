package com.athi.util;

import javafx.fxml.FXMLLoader;

import java.net.URL;
import java.util.Optional;

/**
 * Created by mp2.
 */
public interface FXMLDefinition {

    String getFXMLPath();

    String getFXMLName();

    default <T> Optional<T> load() {
        String fxmlPath = getFXMLPath().endsWith("/") ? getFXMLPath() : getFXMLPath() + "/";
        String fxmlName = getFXMLName().endsWith(".fxml") ? getFXMLName() : getFXMLName() + ".fxml";
        String fxmlFullPath = fxmlPath + fxmlName;

        URL fxmlResource = Thread.currentThread().getContextClassLoader().getResource(fxmlFullPath);

        try {
            return Optional.of(FXMLLoader.load(fxmlResource));
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

}
