package com.witype.hfmsample.utils.config;

import com.witype.hfmsample.entity.Project;

import java.io.*;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Properties;

/**
 * Created by Typer_work on 2016/12/12.
 * email:witype716@gmail.com
 * desc:
 */
public class Config {

    static {
        try {
            String temp = URLDecoder.decode(Config.class.getProtectionDomain().getCodeSource().getLocation().getFile(), "UTF-8");
            path = temp.substring(1, temp.lastIndexOf('/'));
        } catch (UnsupportedEncodingException e) {
            path = "";
        }
    }

    private static final String CONFIG_FILE_NAME = "config.properties";

    private static String path;

    private File configFile;

    private Properties properties = new Properties();

    private static Config config = new Config();

    public Config() {
        configFile = new File("e://temp//");
        if (!configFile.exists()) configFile.mkdirs();
        configFile = new File(configFile, CONFIG_FILE_NAME);
        if (!configFile.exists()) {
            try {
                configFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static Config get() {
        return config;
    }

    public void store(String key, String value) {
        store(key, value, null);
    }

    public void store(String key, String value, String comment) {
        try {
            properties.setProperty(key, value);
            saveProperties(comment);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isLogin() {
        return !load(ConfigConstant.CONFIG_LOGIN_MODE, "GUEST").equals(LoginMode.GUEST.getLoginMode());
    }

    @SuppressWarnings("all")
    public <T> T load(String key, T def) {
        try {
            InputStream in = new BufferedInputStream(new FileInputStream(configFile));
            properties.load(in);     ///加载属性列表
            String property = properties.getProperty(key);
            in.close();
            if (property == null) return def;
            if (def instanceof String) {
                return (T) property;
            } else if (def instanceof Boolean) {
                Boolean result = Boolean.parseBoolean(property);
                return (T) result;
            } else if (def instanceof Integer) {
                Integer integer = Integer.parseInt(property);
                return (T) integer;
            } else if (def instanceof Long) {
                Long aLong = Long.parseLong(property);
                return (T) aLong;
            } else if (def instanceof Double) {
                Double aDouble = Double.parseDouble(property);
                return (T) aDouble;
            } else if (def instanceof Float) {
                Float aFloat = Float.parseFloat(property);
                return (T) aFloat;
            } else {
                return (T) property;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return def;
    }

    private void saveProperties(String comment) throws Exception {
        FileOutputStream fos = new FileOutputStream(configFile);
        properties.store(fos, comment);
        fos.close();
    }

}
