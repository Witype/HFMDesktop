package com.witype.hfmsample.controller;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.HBox;

import java.awt.*;
import java.net.URI;

public class LoginController extends Controller {

    @FXML
    CheckBox checkRemember;
    @FXML
    private HBox loginRoot;

    @Override
    public Parent getParent() {
        return loginRoot;
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

}
