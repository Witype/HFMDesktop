package com.witype.hfmsample.app;

import com.witype.hfmsample.controller.Controller;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

/**
 * Created by Typer_work on 2016/12/9.
 * email:witype716@gmail.com
 * desc:
 */
public abstract class App<T extends Controller> {

    private static String PREFIX = "/fxml/";
    private static String SUFFIX = ".fxml";

    private Parent node;

    private String title;

    private T controller;

    public abstract String getPageName();

    public String getTitle() {
        return title;
    }

    public abstract String getFxml();

    public boolean closeAble() {
        return true;
    }

    private String generatePath() {
        return String.format("%s%s%s",PREFIX,getFxml(),SUFFIX);
    }

    public T getController() {
        return controller;
    }

    public App() {
        this.title = getPageName();
        init();
    }

    public App(String title) {
        this.title = title;
        init();
    }

    private void init() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(generatePath()));
            node = loader.load();
            controller = loader.getController();
            if (controller != null) {
                controller.setName(getTitle());
                controller.onAppear();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Parent getNode() {
        return node;
    }
}
