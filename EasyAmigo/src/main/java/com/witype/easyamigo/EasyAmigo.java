package com.witype.easyamigo;

import net.dongliu.apk.parser.bean.ApkMeta;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by Typer_work on 2016/10/26 0026.
 *
 */
public interface EasyAmigo {

    /**
     * get ApkMeta by String
     * @param path
     * @return ApkMeta
     */
    ApkMeta getApkMeta(File path);

    /**
     *
     * @return
     */
    ArrayList<ApkMeta> getAll(String flavorName);

    /**
     *
     * @param flavorName
     * @return ApkMeta
     */
    ApkMeta getLatestVersionByFlavor(String flavorName);

    /**
     *
     * @param file
     */
    void updateVersion(File... file);

    DiffEntity getDiff(ApkMeta from,ApkMeta to);

    int getFlavorNumber(String flavorName);
}
