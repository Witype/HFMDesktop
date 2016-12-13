package com.witype.easyamigo;

/**
 * Created by Typer_work on 2016/12/13.
 * email:witype716@gmail.com
 * desc:
 */
public class Flavor {

    public String flavorName;

    public String desc;

    public Flavor(String flavorName) {
        this.flavorName = flavorName;
    }

    public Flavor(String flavorName, String desc) {
        this.flavorName = flavorName;
        this.desc = desc;
    }

    public String path() {
        return EnvironmentImpl.get().getFlavorPath(flavorName);
    }
}
