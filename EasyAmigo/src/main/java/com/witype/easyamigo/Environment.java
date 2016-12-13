package com.witype.easyamigo;

import net.dongliu.apk.parser.bean.ApkMeta;

/**
 * Created by Typer_work on 2016/10/26 0026.
 */
public interface Environment {

    String getWorkSpace();

    String getDiffWorkspace(String flavorName);

    String getFullDiff(String flavorName);

    String getIncrementalWorkspace(String flavorName);

    String getVersion(String flavorName);

    String getFlavorPath(String flavorName);

    String getTempPath();

    String getLibPath();

    String getDiffFileName(ApkMeta from,ApkMeta to);

    String getIncrementalFileName(ApkMeta from,ApkMeta to);

    String getFullFileName(ApkMeta from,ApkMeta to);
}
