package com.witype.hfmsample.controller;

import javafx.fxml.FXML;
import javafx.scene.layout.StackPane;

/**
 * Created by WiType on 2016/12/8.
 * Email:witype@gmail.com
 * Desc:
 */
class Controller {

    @FXML
    private StackPane closePane;

    @FXML
    protected void onCloseClick() {
        closePane.getScene().getWindow().hide();
    }

    @FXML
    protected void onWindowMinClick() {

    }

    @FXML
    protected void onSettingClick() {

    }

    @FXML
    protected void onAboutClick() {

    }
}
