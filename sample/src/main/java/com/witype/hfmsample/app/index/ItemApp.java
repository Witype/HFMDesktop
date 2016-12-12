package com.witype.hfmsample.app.index;

import com.witype.hfmsample.app.App;

/**
 * Created by Typer_work on 2016/12/12.
 * email:witype716@gmail.com
 * desc:
 */
public class ItemApp extends App {

    public ItemApp(String title) {
        super(title);
    }

    @Override
    public String getPageName() {
        return "ÏîÄ¿item";
    }

    @Override
    public String getFxml() {
        return "item_index";
    }
}
