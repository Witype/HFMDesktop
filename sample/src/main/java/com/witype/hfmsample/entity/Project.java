package com.witype.hfmsample.entity;

/**
 * Created by Typer_work on 2016/12/12.
 * email:witype716@gmail.com
 * desc:
 */
public class Project {

    private String path;
    private String name;
    private String appKey;
    private String createTimestamp;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(String createTimestamp) {
        this.createTimestamp = createTimestamp;
    }
}
