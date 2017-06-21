package com.athi.util;

/**
 * Created by mp2.
 */
public enum FXMLDefinitionImpl implements FXMLDefinition {
    WELCOME("com/athi/welcome/", "welcome"),
    MAIN("com/athi/main/", "main"),;

    private final String fxmlPath;
    private final String fxmlName;

    FXMLDefinitionImpl(String fxmlPath, String fxmlName) {
        this.fxmlPath = fxmlPath;
        this.fxmlName = fxmlName;
    }

    @Override
    public String getFXMLPath() {
        return fxmlPath;
    }

    @Override
    public String getFXMLName() {
        return fxmlName;
    }
}
