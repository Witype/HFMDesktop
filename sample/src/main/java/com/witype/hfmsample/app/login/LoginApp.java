package com.witype.hfmsample.app.login;

import com.witype.hfmsample.app.App;

/**
 * Created by Typer_work on 2016/12/9.
 * email:witype716@gmail.com
 * desc:
 */
public class LoginApp extends App {

    @Override
    public String getPageName() {
        return "��¼";
    }

    @Override
    public String getFxml() {
        return "login";
    }

    @Override
    public boolean closeAble() {
        return false;
    }
}
