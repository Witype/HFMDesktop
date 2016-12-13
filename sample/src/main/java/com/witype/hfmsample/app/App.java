package com.witype.hfmsample.app;

import com.witype.hfmsample.controller.RootController;
import com.witype.hfmsample.utils.config.Intent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

/**
 * Created by Typer_work on 2016/12/9.
 * email:witype716@gmail.com
 * desc:
 */
public abstract class App {

    private static String PREFIX = "/fxml/";
    private static String SUFFIX = ".fxml";
    private Intent data;

    private Parent node;

    private String title;

    public abstract String getPageName();

    public App() {
        this.title = getPageName();
    }

    public App(String title) {
        this.title = title;
    }

    public void onAppear(Intent intent) {}

    public void onNewIntent(Intent intent) {}

    public String getTitle() {
        return title;
    }

    public LauncherMode getLauncherMode() {
        return LauncherMode.DEFAULT;
    }

    public abstract String getFxml();

    public boolean closeAble() {
        return true;
    }

    private String generatePath() {
        return String.format("%s%s%s",PREFIX,getFxml(),SUFFIX);
    }

    private void init() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(generatePath()));
            loader.setController(this);
            node = loader.load();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Parent getNode() {
        if (node == null) init();
        return node;
    }

    public void startApp(Intent intent) {
        RootController.startApp(intent);
    }

    public void finish() {
        RootController.finish(this);
    }
}
