package com.witype.easyamigo;

import net.dongliu.apk.parser.bean.ApkMeta;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

/**
 * Created by Typer_work on 2016/10/26 0026.
 *
 */
public class BSPatch {

    private ApkMeta from;
    private ApkMeta to;
    private String patchFolder;
    private String patchFileName;

    public BSPatch() {}

    public BSPatch from(ApkMeta from) {
        this.from = from;
        return this;
    }

    public BSPatch to(ApkMeta to) {
        this.to = to;
        return this;
    }

    public BSPatch patchFolder(String patchFolder) {
        this.patchFolder = patchFolder;
        return this;
    }

    public BSPatch patchFileName(String patchFileName) {
        this.patchFileName = patchFileName;
        return this;
    }

    public int go() {
        return generatePatchFile(from.getFilePath(), to.getFilePath(), patchFolder, patchFileName);
    }

    public static int generatePatchFile(String oldApkPath, String newApkPath, String patchFolder, String patchFileName) {
        String cmd = "cmd /c %s %s %s %s";
        String bsdiffPath = new File(EnvironmentImpl.class.getResource(EnvironmentImpl.LIB_PATH).getFile()).getPath();
        File patchFile = new File(patchFolder, patchFileName);
        BufferedReader br = null;
        try {
            Process process = Runtime.getRuntime().exec(String.format(cmd, bsdiffPath, oldApkPath, newApkPath,patchFile.getPath()));
            process.waitFor();
            br = new BufferedReader(new InputStreamReader(process.getInputStream()));
            while ((br.readLine()) != null);
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
