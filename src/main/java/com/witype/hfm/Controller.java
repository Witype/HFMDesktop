package com.witype.hfm;

import javafx.fxml.FXML;
import javafx.scene.layout.StackPane;

public class Controller {

    @FXML
    StackPane settingPane;//fx:id="settingPane"
    @FXML
    StackPane closePane;

    @FXML
    protected void onSettingClick() {

    }

    @FXML
    protected void onAboutClick() {

    }

    @FXML
    protected void onCloseClick() {
        closePane.getScene().getWindow().hide();
    }

    @FXML
    protected void onWindowMinClick() {

    }


}
