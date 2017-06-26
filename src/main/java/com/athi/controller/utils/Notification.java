package com.athi.controller.utils;

import com.sun.javafx.stage.StageHelper;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.util.Duration;

import static com.athi.util.Stylesheets.NOTIFICATION;

/**
 * Created by Athi
 */
public final class Notification {

    private static final double WIDTH = 500;
    private static final double DEFAULT_HEIGHT = 80;
    private static double HEIGHT = DEFAULT_HEIGHT;

    private static final Duration ANIMATION_TIME = Duration.millis(500);
    private static final Duration DURATION = Duration.millis(5000);

    private static final String ERROR_STYLE = "errorNotification";
    private static final String WARNING_STYLE = "warningNotification";
    private static final String INFO_STYLE = "infoNotification";
    private static final String SUCCESS_STYLE = "successNotification";

    private static final String TITLE_STYLE = "title";
    private static final String MESSAGE_STYLE = "message";
    private static final String NOTIFICATION_STYLE = "notification";

    private static Stage stage;

    /**
     * Show ERROR Notification
     */
    public static void error(String title, String message) {
        notify(title, message, ERROR_STYLE);
    }


    /**
     * Show WARNING Notification
     */
    public static void warning(String title, String message) {
        notify(title, message, WARNING_STYLE);
    }

    /**
     * Show INFO Notification
     */
    public static void info(String title, String message) {
        notify(title, message, INFO_STYLE);
    }

    /**
     * Show SUCCESS Notification
     */
    public static void success(String title, String message) {
        notify(title, message, SUCCESS_STYLE);
    }

    private static void notify(String title, String message, String colorStyle) {
        setStage();
        showPopup(title, message, colorStyle);
    }

    private static void showPopup(String title, String message, String colorStyle) {
        HEIGHT = DEFAULT_HEIGHT;
        changeHeightBasedOnMessage(message);

        Label titleLabel = new Label(title);
        titleLabel.setPrefWidth(WIDTH);
        titleLabel.getStyleClass().add(TITLE_STYLE);

        Label messageLabel = new Label(message);
        messageLabel.setPrefWidth(WIDTH);
        messageLabel.setWrapText(true);
        messageLabel.getStyleClass().add(MESSAGE_STYLE);

        VBox popupLayout = new VBox();
        popupLayout.setSpacing(10);
        popupLayout.setPadding(new Insets(10, 10, 10, 10));
        popupLayout.getChildren().addAll(titleLabel, messageLabel);

        StackPane popupContent = new StackPane();
        popupContent.setPrefSize(WIDTH, HEIGHT);
        popupContent.getStyleClass().add(NOTIFICATION_STYLE);
        popupContent.getStyleClass().add(colorStyle);
        popupContent.getChildren().addAll(popupLayout);

        Popup popup = new Popup();
        popup.setX(stage.getX() + (stage.getWidth() - WIDTH) * 0.5);
        popup.setY(stage.getY() + (stage.getHeight() - HEIGHT) / 2 - 25);
        popup.getContent().add(popupContent);
        popup.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> popup.hide());

        KeyValue fadeOutBegin = new KeyValue(popup.opacityProperty(), 1.0);
        KeyValue fadeOutEnd = new KeyValue(popup.opacityProperty(), 0.0);

        KeyFrame kfBegin = new KeyFrame(Duration.ZERO, fadeOutBegin);
        KeyFrame kfEnd = new KeyFrame(ANIMATION_TIME, fadeOutEnd);

        Timeline timeline = new Timeline(kfBegin, kfEnd);
        timeline.setDelay(DURATION);
        timeline.setOnFinished(actionEvent -> Platform.runLater(popup::hide));

        popup.show(stage);
        timeline.play();
    }

    private static void setStage() {
        ObservableList<Stage> stages = StageHelper.getStages();
        if (!stages.isEmpty()) {
            Stage stage = StageHelper.getStages().get(0);
            Notification.stage = stage;
            NOTIFICATION.style(stage);
        }
    }


    private static void changeHeightBasedOnMessage(String message) {
        String[] split = message.split("\n");
        int wraps = split.length;

        for (String str : split) {
            int strWraps = (int) Math.ceil(str.length() / 100);
            wraps += strWraps;
        }

        if (wraps > 0) {
            HEIGHT = (HEIGHT + (wraps * 12));
        }
    }
}