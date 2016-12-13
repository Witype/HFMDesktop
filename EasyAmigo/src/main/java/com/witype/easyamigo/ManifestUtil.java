package com.witype.easyamigo;

import net.dongliu.apk.parser.ApkParser;
import net.dongliu.apk.parser.bean.ApkMeta;
import net.dongliu.apk.parser.bean.UseFeature;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by Typer_work on 2016/9/28 0028.
 */
public class ManifestUtil {

    public static ArrayList<String> getElement(String filePath, String elementName){

        return new ArrayList<>();
    }

    public static ApkMeta getVersionAndFlavor(String filePath) {
        try(ApkParser apkParser = new ApkParser(new File(filePath))) {
            ApkMeta apkMeta = apkParser.getApkMeta();
            apkParser.close();
            return apkMeta;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
