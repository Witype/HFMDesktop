package com.witype.hfmsample.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

/**
 * Created by Typer_work on 2016/12/13.
 * email:witype716@gmail.com
 * desc:
 */
public class ViewHolder {

    private static String PREFIX = "/fxml/";
    private static String SUFFIX = ".fxml";

    private Parent parent;

    private String fxml;

    public ViewHolder(String fxml) {
        this.fxml = fxml;
        try {
            parent = FXMLLoader.load(getClass().getResource(generatePath()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public Parent getParent() {
        return parent;
    }

    private String generatePath() {
        return String.format("%s%s%s",PREFIX,fxml,SUFFIX);
    }
}
