package com.witype.hfmsample.utils.config;

import com.witype.hfmsample.app.App;

import java.io.Serializable;
import java.util.HashMap;

/**
 * Created by Typer_work on 2016/12/13.
 * email:witype716@gmail.com
 * desc:
 */
public class Intent {

    private HashMap<String,String> stringHashMap;
    private HashMap<String,Object> objectHashMap;

    private App app;

    public <T extends App> Intent(Class<T> aClass) {
        try {
            app = aClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public App getApp() {
        return app;
    }

    public void put(String key, String value) {
        if (stringHashMap == null) stringHashMap = new HashMap<String, String>();
        stringHashMap.put(key,value);
    }

    @SuppressWarnings("all")
    public <T> T get(String key,T def) {
        if (def instanceof String) {
            return (T) stringHashMap.get(key);
        }
//        else if (def instanceof Boolean) {
//            Boolean result = Boolean.parseBoolean(property);
//            return (T) result;
//        } else if (def instanceof Integer) {
//            Integer integer = Integer.parseInt(property);
//            return (T) integer;
//        } else if (def instanceof Long) {
//            Long aLong = Long.parseLong(property);
//            return (T) aLong;
//        } else if (def instanceof Double) {
//            Double aDouble = Double.parseDouble(property);
//            return (T) aDouble;
//        } else if (def instanceof Float) {
//            Float aFloat = Float.parseFloat(property);
//            return (T) aFloat;
//        }
        else {
            return (T) objectHashMap.get(key);
        }
    }
}
