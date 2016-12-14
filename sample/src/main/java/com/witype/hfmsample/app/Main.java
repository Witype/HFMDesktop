package com.witype.hfmsample.app;

import com.witype.hfmsample.app.index.Index;
import com.witype.hfmsample.app.login.LoginApp;
import com.witype.hfmsample.controller.RootController;
import com.witype.hfmsample.utils.config.Config;
import com.witype.hfmsample.utils.Intent;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

    private RootController rootController;

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/content.fxml"));
        Parent root = loader.load();
        Scene rootScene = new Scene(root);
        rootController = loader.getController();
        onCreate(primaryStage,rootScene);
        primaryStage.setTitle("Hello World");
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(rootScene);
        primaryStage.show();
    }

    private void onCreate(Stage primaryStage,Scene rootScene) throws Exception {
        rootController.init(primaryStage,rootScene);
        launcher();
    }

    private void launcher() {
        if (Config.get().isLogin()) {
            RootController.startApp(new Intent(Index.class));
        } else {
            RootController.startApp(new Intent(LoginApp.class));
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}
