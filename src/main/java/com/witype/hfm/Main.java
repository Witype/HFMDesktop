package com.witype.hfm;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application implements EventHandler<MouseEvent> {

    private double xOffset = 0;
    private double yOffset = 0;
    private boolean isDragged = false;
    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/sample.fxml"));
        setOnDraggedListener(root);
        Scene rootScene = new Scene(root);
        root.getStylesheets().add("/css/style_title_bar.css");
        primaryStage.setTitle("Hello World");
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(rootScene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private void setOnDraggedListener(Parent root) {
        root.setOnMousePressed(this);
        root.setOnMouseDragged(this);
        root.setOnMouseReleased(this);
    }

    public void handle(MouseEvent event) {
        EventType eventType = event.getEventType();
        if (eventType == MouseEvent.MOUSE_PRESSED) {
            isDragged = isInDraggedArea(event);
            if (!isDragged) return;
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        } else if (eventType == MouseEvent.MOUSE_DRAGGED) {
            if (isDragged) {
                primaryStage.setX(event.getScreenX() - xOffset);
                primaryStage.setY(event.getScreenY() - yOffset);
            }
        } else if (eventType == MouseEvent.MOUSE_RELEASED) {
            isDragged = false;
        }
    }

    private boolean isInDraggedArea(MouseEvent event) {
        return event.getY() <= 30 && event.getX() < primaryStage.getWidth() - 120;
    }
}
