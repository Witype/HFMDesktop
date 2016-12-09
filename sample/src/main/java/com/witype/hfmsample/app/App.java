package com.witype.hfmsample.app;

import com.witype.hfmsample.app.about.AboutController;
import com.witype.hfmsample.controller.Controller;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

/**
 * Created by Typer_work on 2016/12/9.
 * email:witype716@gmail.com
 * desc:
 */
public abstract class App {

    private Parent node;

    private Controller controller;

    public abstract String getName();

    public abstract String getFxml();

    public boolean closeAble() {
        return true;
    }

    public Controller getController() {
        return controller;
    }

    public App() {
        init();
    }

    private void init() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(getFxml()));
            node = loader.load();
            controller = loader.getController();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Parent getNode() {
        return node;
    }
}
