package com.athi.util;

import javafx.fxml.FXMLLoader;

import java.net.URL;
import java.util.Optional;

/**
 * Created by mp2.
 */
public enum FXMLDefinition {
    WELCOME("welcome/", "welcome"),
    MAIN("main/", "main"),;

    private static final String PATH_PREFIX = "com/athi/";
    private static final String PATH_SUFIX = ".fxml";

    private final String fxmlPath;
    private final String fxmlName;

    FXMLDefinition(String fxmlPath, String fxmlName) {
        this.fxmlPath = fxmlPath;
        this.fxmlName = fxmlName;
    }

    public String getFxmlPath() {
        return fxmlPath;
    }

    public String getFxmlName() {
        return fxmlName;
    }

    public static <T> Optional<T> load(FXMLDefinition fxmlDefinition) {
        StringBuilder fullPath = new StringBuilder(PATH_PREFIX)
                .append(fxmlDefinition.getFxmlPath())
                .append(fxmlDefinition.getFxmlName())
                .append(PATH_SUFIX);

        URL fxmlResource = Thread.currentThread().getContextClassLoader().getResource(fullPath.toString());

        try {
            return Optional.of(FXMLLoader.load(fxmlResource));
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }
}
