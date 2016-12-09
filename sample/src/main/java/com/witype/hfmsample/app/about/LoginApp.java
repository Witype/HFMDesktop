package com.witype.hfmsample.app.about;

import com.witype.hfmsample.app.App;

/**
 * Created by Typer_work on 2016/12/9.
 * email:witype716@gmail.com
 * desc:
 */
public class LoginApp extends App {

    @Override
    public String getName() {
        return "µÇÂ¼";
    }

    @Override
    public String getFxml() {
        return "/fxml/login.fxml";
    }

    @Override
    public boolean closeAble() {
        return getController().isLogin();
    }
}
