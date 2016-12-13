package com.witype.hfmsample.app.channel;

import com.witype.easyamigo.EnvironmentImpl;
import com.witype.hfmsample.app.App;
import com.witype.hfmsample.app.LauncherMode;
import com.witype.hfmsample.utils.config.BundleConstant;
import com.witype.hfmsample.utils.config.Intent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;

/**
 * Created by Typer_work on 2016/12/13.
 * email:witype716@gmail.com
 * desc:
 */
public class ChannelApp extends App {

    @FXML
    private FlowPane list_content;

    @Override
    public String getPageName() {
        return "ÇþµÀ";
    }

    @Override
    public LauncherMode getLauncherMode() {
        return LauncherMode.SINGLE_TOP;
    }

    @Override
    public String getFxml() {
        return "list_content";
    }

    @Override
    public void onAppear(Intent intent) {
        super.onAppear(intent);
        String workSpace = intent.get(BundleConstant.WORK_SPACE, EnvironmentImpl.DEFAULT_WORKSPACE);
        list_content.getChildren().add(new Label(workSpace));
    }

    @Override
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        String workSpace = intent.get(BundleConstant.WORK_SPACE, EnvironmentImpl.DEFAULT_WORKSPACE);
        list_content.getChildren().add(new Label(workSpace));
    }
}
