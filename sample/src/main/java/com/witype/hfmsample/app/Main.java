package com.witype.hfmsample.app;

import com.witype.hfmsample.controller.Controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

    private Controller controller;

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/content.fxml"));
        Parent root = loader.load();
        Scene rootScene = new Scene(root);
        controller = loader.getController();
        onCreate(primaryStage,rootScene);
        primaryStage.setTitle("Hello World");
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(rootScene);
        primaryStage.show();
    }

    private void onCreate(Stage primaryStage,Scene rootScene) throws Exception {
        controller.init(primaryStage,rootScene);
        controller.launcher();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
