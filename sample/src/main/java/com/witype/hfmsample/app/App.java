package com.witype.hfmsample.app;

import com.witype.hfmsample.controller.RootController;
import com.witype.hfmsample.presenter.IPresenter;
import com.witype.hfmsample.presenter.Presenter;
import com.witype.hfmsample.utils.Intent;
import com.witype.hfmsample.view.IView;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

/**
 * Created by Typer_work on 2016/12/9.
 * email:witype716@gmail.com
 * desc:
 */
public abstract class App<T extends IPresenter> implements IView {

    private static String PREFIX = "/fxml/";
    private static String SUFFIX = ".fxml";
    private Intent data;

    private Parent node;

    private String title;

    private T presenter;

    public T getPresenter() {
        return presenter;
    }

    @SuppressWarnings("all")
    public T initPresenter() {
        return presenter = (T) new Presenter(this);
    }

    public abstract String getPageName();

    public App() {
        this.title = getPageName();
        init();
    }

    public App(String title) {
        this.title = title;
        init();
    }

    public void init() {
        presenter = initPresenter();
    }

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

    private void initParent() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(generatePath()));
            loader.setController(this);
            node = loader.load();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Parent getNode() {
        if (node == null) initParent();
        return node;
    }

    public void onAppear(Intent intent) {}

    public void onNewIntent(Intent intent) {}

    public void startApp(Intent intent) {
        RootController.startApp(intent);
    }

    public void finish() {
        RootController.finish(this);
    }
}
