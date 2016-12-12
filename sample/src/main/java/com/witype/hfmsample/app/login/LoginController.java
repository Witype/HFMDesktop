package com.witype.hfmsample.app.login;

import com.witype.hfmsample.app.index.Index;
import com.witype.hfmsample.controller.RootController;
import com.witype.hfmsample.controller.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.HBox;

import java.awt.*;
import java.net.URI;

public class LoginController extends Controller {

    @FXML
    private
    CheckBox checkRemember;
    @FXML
    private HBox loginRoot;

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
        RootController.startApp(new Index());
        RootController.finish(this);
    }

}
