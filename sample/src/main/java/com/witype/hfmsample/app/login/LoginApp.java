package com.witype.hfmsample.app.login;

import com.witype.hfmsample.app.App;
import com.witype.hfmsample.app.LauncherMode;
import com.witype.hfmsample.app.index.Index;
import com.witype.hfmsample.utils.config.Config;
import com.witype.hfmsample.utils.constant.ConfigConstant;
import com.witype.hfmsample.utils.Intent;
import com.witype.hfmsample.utils.LoginMode;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.HBox;

import java.awt.*;
import java.net.URI;

/**
 * Created by Typer_work on 2016/12/9.
 * email:witype716@gmail.com
 * desc:
 */
public class LoginApp extends App {

    @FXML
    private
    CheckBox checkRemember;
    @FXML
    private HBox loginRoot;

    @Override
    public String getPageName() {
        return "µÇÂ¼";
    }

    @Override
    public String getFxml() {
        return "login";
    }

    @Override
    public LauncherMode getLauncherMode() {
        return LauncherMode.SINGLE_TOP;
    }

    @Override
    public boolean closeAble() {
        return false;
    }

    @FXML
    protected void onRememberMeClick() {
        System.out.println(checkRemember.isSelected());
    }

    @FXML
    protected void onForgetClick() throws Exception {
        Desktop.getDesktop().browse(URI.create("http://www.baidu.com"));
    }

    @FXML
    protected void onLoginClick() {

    }

    @FXML
    protected void onRegisterClick() {

    }

    @FXML
    protected void onLocalClick() {
        Config.get().store(ConfigConstant.CONFIG_LOGIN_MODE, LoginMode.LOCAL.getLoginMode());
        startApp(new Intent(Index.class));
        finish();
    }
}
