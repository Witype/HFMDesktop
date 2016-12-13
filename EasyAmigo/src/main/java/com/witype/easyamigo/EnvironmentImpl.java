package com.witype.easyamigo;

import net.dongliu.apk.parser.bean.ApkMeta;

/**
 * Created by Typer_work on 2016/10/26 0026.
 */
public class EnvironmentImpl implements Environment {

    String DIFF = "\\%s\\diff";
    String INCREMENTAL = "\\%s\\incremental";
    String FULL_DIFF = "\\%s\\full";
    String VERSION = "\\%s\\version";
    public static final String LIB_PATH = "/bsdiff.exe";
    public static final String DIFF_FILE_NAME_FORMAT = "diff-%s-%s.apk";
    public static final String INCREMENTAL_NAME_FORMAT = "incremental-%s-%s.apk";
    public static final String FULL_NAME_FORMAT = "full-diff-%s-%s.apk";
    public static final String APK = ".apk";

    private static Environment environment = new EnvironmentImpl();

    public static Environment get() {
        return environment;
    }

    public static void setEnvironment(Environment newEnvironment) {
        environment = newEnvironment;
    }

    public static final String DEFAULT_WORKSPACE = ".\\amigo\\";

    private String workSpace = DEFAULT_WORKSPACE;

    public EnvironmentImpl() {
        this(DEFAULT_WORKSPACE);
    }

    public EnvironmentImpl(String workSpace) {
        this.workSpace = workSpace;
    }

    @Override
    public String getWorkSpace() {
        return workSpace;
    }

    @Override
    public String getDiffWorkspace(String flavorName) {
        return String.format(workSpace + DIFF,flavorName);
    }

    @Override
    public String getFullDiff(String flavorName) {
        return String.format(workSpace + FULL_DIFF,flavorName);
    }

    @Override
    public String getIncrementalWorkspace(String flavorName) {
        return String.format(workSpace + INCREMENTAL,flavorName);
    }

    @Override
    public String getVersion(String flavorName) {
        return String.format(workSpace + VERSION,flavorName);
    }

    @Override
    public String getFlavorPath(String flavorName) {
        return String.format(workSpace + flavorName);
    }

    @Override
    public String getTempPath() {
        return null;
    }

    @Override
    public String getLibPath() {
        return LIB_PATH;
    }

    @Override
    public String getDiffFileName(ApkMeta from, ApkMeta to) {
        return String.format(DIFF_FILE_NAME_FORMAT,formatName(from.getFileName()),formatName(to.getFileName()));
    }

    @Override
    public String getIncrementalFileName(ApkMeta from, ApkMeta to) {
        return String.format(INCREMENTAL_NAME_FORMAT,formatName(from.getFileName()),formatName(to.getFileName()));
    }

    @Override
    public String getFullFileName(ApkMeta from, ApkMeta to) {
        return String.format(FULL_NAME_FORMAT,formatName(from.getFileName()),formatName(to.getFileName()));
    }

    public String formatName(String name) {
        return name.replace(APK,"");
    }
}
