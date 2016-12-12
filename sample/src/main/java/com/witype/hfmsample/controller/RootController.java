package com.witype.hfmsample.controller;

import com.witype.hfmsample.app.App;
import com.witype.hfmsample.app.about.AboutApp;
import com.witype.hfmsample.app.login.LoginApp;
import com.witype.hfmsample.utils.config.Config;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Created by WiType on 2016/12/8.
 * Email:witype@gmail.com
 * Desc:
 */
public class RootController implements EventHandler<MouseEvent> {

    private double xOffset = 0;
    private double yOffset = 0;
    private boolean isDragged = false;
    private Stage stage;

    @FXML
    private HBox titleBarContent;
    @FXML
    private HBox navigationContent;
    @FXML
    public StackPane content;
    @FXML
    private StackPane closePane;

    private Parent currentShowParent;

    private Navigation navigation;

    private static RootController rootController;

    public void init(Stage stage,Scene root) {
        this.stage = stage;
        rootController = this;
        navigation = new Navigation(this);
        setOnDraggedListener(root);
    }

    public void launcher() {
        if (Config.get().isLogin()) {
            //TODO
        } else {
            startApp(new LoginApp());
        }
    }

    private void setOnDraggedListener(Scene root) {
        root.setOnMousePressed(this);
        root.setOnMouseDragged(this);
        root.setOnMouseReleased(this);
    }

    public void setNavigationVisible(boolean visible) {
        navigationContent.setVisible(visible);
    }

    public static void startApp(App app) {
        if (rootController.currentShowParent == app.getNode()) return;
        rootController.content.getChildren().add(app.getNode());
        rootController.addNavigation(app);
    }

    public static void finishApp(App app) {
        rootController.content.getChildren().remove(app.getNode());
    }

    public static void finish(Controller controller) {
        rootController.navigation.closeByTitle(controller.getName());
    }

    public static int getItemCount() {
        return rootController.navigation.getItemCount();
    }

    void finishNavigation(Parent parent) {
        navigationContent.getChildren().remove(parent);
    }

    private void addNavigation(App app) {
        Parent parent = navigation.addNavigation(app);
        if (parent != null) {
            navigationContent.getChildren().add(parent);
        }
    }

    public void topApp(App app) {
        content.getChildren().removeAll(app.getNode());
        content.getChildren().add(app.getNode());
    }

    public Parent getParent() {
        return null;
    }

    @FXML
    protected void onCloseClick() {
        closePane.getScene().getWindow().hide();
    }

    @FXML
    protected void onWindowMinClick() {
        if (stage != null) stage.setIconified(true);
    }

    @FXML
    protected void onSettingClick() {

    }

    @FXML
    protected void onAboutClick() throws Exception {
        startApp(new AboutApp());
    }

    public String getName() {
        return "RootController";
    }

    public void handle(MouseEvent event) {
        EventType eventType = event.getEventType();
        if (eventType == MouseEvent.MOUSE_PRESSED) {
            isDragged = isInDraggedArea(event);
            if (!isDragged) return;
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        } else if (eventType == MouseEvent.MOUSE_DRAGGED) {
            Stage stage = (Stage) titleBarContent.getScene().getWindow();
            if (isDragged && stage != null) {
                stage.setX(event.getScreenX() - xOffset);
                stage.setY(event.getScreenY() - yOffset);
            }
        } else if (eventType == MouseEvent.MOUSE_RELEASED) {
            isDragged = false;
        }
    }

    private boolean isInDraggedArea(MouseEvent event) {
        return event.getY() <= 30 && event.getX() < titleBarContent.getWidth() - 120;
    }

}
