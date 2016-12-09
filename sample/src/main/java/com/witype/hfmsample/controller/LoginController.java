package com.witype.hfmsample.controller;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;

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
