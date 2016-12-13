package com.witype.hfmsample.utils.config;

/**
 * Created by Typer_work on 2016/12/12.
 * email:witype716@gmail.com
 * desc:
 */
public enum LoginMode {
    GUEST("GUEST", 0),
    LOCAL("LOCAL", 1),
    LOGIN("LOCAL", 2),;

    private String loginMode;
    private int key;

    LoginMode(String loginMode, int key) {
        this.loginMode = loginMode;
        this.key = key;
    }

    public String getLoginMode() {
        return loginMode;
    }

    public void setLoginMode(String loginMode) {
        this.loginMode = loginMode;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public LoginMode getMode(int key) {
        switch (key) {
            case 0:
                return GUEST;
            case 1:
                return LOCAL;
            default:
                return GUEST;
        }
    }

}
