package com.witype.hfmsample.app.index;

import com.witype.hfmsample.app.App;

/**
 * Created by Typer_work on 2016/12/12.
 * email:witype716@gmail.com
 * desc:
 */
public class Index extends App<IndexController> {

    @Override
    public String getPageName() {
        return "ึ๗าณ";
    }

    @Override
    public String getFxml() {
        return "index";
    }

    @Override
    public boolean closeAble() {
        return false;
    }

}
