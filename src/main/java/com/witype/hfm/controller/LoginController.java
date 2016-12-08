package com.witype.hfm.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.HBox;

import java.awt.*;
import java.net.URI;

public class LoginController extends Controller {

    @FXML
    CheckBox checkRemember;

    @FXML
    protected void onRememberMeClick() {
        System.out.println(checkRemember.isSelected());
    }

    @FXML
    protected void onForgetClick() throws Exception {

    }

    @FXML
    protected void onLoginClick() {

    }

    @FXML
    protected void onRegisterClick() {

    }

}
