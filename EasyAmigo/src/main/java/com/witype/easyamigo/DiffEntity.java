package com.witype.easyamigo;

import net.dongliu.apk.parser.bean.ApkMeta;

import java.io.File;

/**
 * Created by Typer_work on 2016/9/21 0021.
 */
public class DiffEntity {

    private String flavorsName;
    private ApkMeta from;
    private ApkMeta to;
    private String fileName;
    private String filePath;

    public DiffEntity() {
    }

    public DiffEntity(ApkMeta from, ApkMeta to) {
        this.from = from;
        this.to = to;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public ApkMeta getFrom() {
        return from;
    }

    public void setFrom(ApkMeta from) {
        this.from = from;
    }

    public ApkMeta getTo() {
        return to;
    }

    public void setTo(ApkMeta to) {
        this.to = to;
    }

    public boolean isGenerateDiffFile() {
        return filePath != null && new File(filePath).exists();
    }

    public String getFlavorsName() {
        return flavorsName;
    }

    public void setFlavorsName(String flavorsName) {
        this.flavorsName = flavorsName;
    }
}
