package com.witype.hfmsample.utils;

import com.google.gson.Gson;

import java.lang.reflect.Type;

/**
 * Created by Typer_work on 2016/7/15 0015.
 */
public class GsonImpl {

    private Gson gson =  new Gson();

    private static GsonImpl json;


    /**
     * get default json handler
     *
     * @return Json
     */
    public static GsonImpl get() {
        if (json == null) {
            //json = new FastJson();
            json = new GsonImpl();
        }
        return json;
    }

    public String toJson(Object src) {
        return gson.toJson(src);
    }

    public <T> T toObject(String json, Class<T> claxx) {
        return gson.fromJson(json, claxx);
    }

    public <T> T toObject(String json, Type type) {
        return gson.fromJson(json, type);
    }

    public <T> T toObject(byte[] bytes, Class<T> claxx) {
        return gson.fromJson(new String(bytes), claxx);
    }
}
