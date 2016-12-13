package com.witype.easyamigo;

import net.dongliu.apk.parser.bean.ApkMeta;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Typer_work on 2016/11/3.
 *
 */
public class EasyAmigoImpl implements EasyAmigo {

    public static ArrayList<Flavor> DEFAULT_FLAVOR_NAME = new ArrayList<Flavor>() {{add(new Flavor("origin"));}};

    private ArrayList<Flavor> flavors;

    private Map<String,ArrayList<ApkMeta>> map = new HashMap<>(0);

    public static EasyAmigoImpl easyAmigo;

    public static EasyAmigo get() {
        return get(null);
    }

    public static EasyAmigo get(ArrayList<Flavor> flavorName) {
        if (easyAmigo == null) easyAmigo = new EasyAmigoImpl(flavorName);
        return easyAmigo;
    }

    public EasyAmigoImpl() {
        this(DEFAULT_FLAVOR_NAME);
        easyAmigo = this;
    }

    public EasyAmigoImpl(ArrayList<Flavor> flavors) {
        if (flavors != null) this.flavors = flavors;
        easyAmigo = this;
    }

    public void setFlavors(ArrayList<Flavor> flavors) {
        this.flavors = flavors;
    }

    public ArrayList<Flavor> getFlavors() {
        return flavors;
    }

    public Environment getEnvironment() {
        return EnvironmentImpl.get();
    }

    @Override
    public ApkMeta getApkMeta(File path) {
        ApkMeta apkInfo = ManifestUtil.getVersionAndFlavor(path.getPath());
        if (apkInfo != null) apkInfo.setFilePath(path.getPath());
        return apkInfo;
    }

    @Override
    public ArrayList<ApkMeta> getAll(String flavorName) {
        ArrayList<ApkMeta> apkInfo = new ArrayList<>(0);
        if (!map.containsKey(flavorName) || map.get(flavorName).size() == 0) {
            File path = new File(EnvironmentImpl.get().getVersion(flavorName));
            if (!path.exists()) return null;
            File files[] = path.listFiles();
            if (files == null || files.length == 0) return null;
            for (File file : files) {
                apkInfo.add(getApkMeta(file));
            }
            map.put(flavorName,apkInfo);
        } else {
            apkInfo = map.get(flavorName);
        }
        return apkInfo;
    }

    public void onRefresh(String flavorName) {
        if (flavorName != null) {
            map.remove(flavorName);
        } else {
            map.clear();
        }
    }

    @Override
    public ApkMeta getLatestVersionByFlavor(String flavorName) {
        ApkMeta latest = null;
        ArrayList<ApkMeta> apkInfos = getAll(flavorName);
        for (ApkMeta apkInfo : apkInfos) {
            if (latest == null || apkInfo.getVersionCode() > latest.getVersionCode()) latest = apkInfo;
        }
        return latest;
    }

    @Override
    public DiffEntity getDiff(ApkMeta from, ApkMeta to) {
        File diffFilePath = new File(EnvironmentImpl.get().getDiffWorkspace(from.getFlavorName()),EnvironmentImpl.get().getDiffFileName(from,to));
        if (!diffFilePath.exists()) diffFilePath = new File(EnvironmentImpl.get().getIncrementalWorkspace(from.getFlavorName()),EnvironmentImpl.get().getFullFileName(from,to));
        if (!diffFilePath.exists()) diffFilePath = new File(EnvironmentImpl.get().getIncrementalWorkspace(from.getFlavorName()),EnvironmentImpl.get().getIncrementalFileName(from,to));
        if (diffFilePath.exists()) {
            DiffEntity diffEntity = new DiffEntity(from,to);
            diffEntity.setFileName(diffFilePath.getName());
            diffEntity.setFilePath(diffFilePath.getPath());
            diffEntity.setFlavorsName(to.getFlavorName());
            return diffEntity;
        }
        return null;
    }

    @Override
    public int getFlavorNumber(String flavorName) {
        return getAll(flavorName).size();
    }

    @Override
    public void updateVersion(File... file) {

    }
}
