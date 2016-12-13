package net.dongliu.apk.parser.bean;

import net.dongliu.apk.parser.Flavor;
import net.dongliu.apk.parser.FlavorImpl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author dongliu
 */
public class ApkMeta {

    private String packageName;
    private String label;
    private String icon;
    private String versionName;
    private Long versionCode;
    private String filePath;
    private Flavor flavor = new FlavorImpl();
    private String installLocation;
    private String minSdkVersion;
    private String targetSdkVersion;
    private String maxSdkVersion;
    private GlEsVersion glEsVersion;
    private boolean anyDensity;
    private boolean smallScreens;
    private boolean normalScreens;
    private boolean largeScreens;

    private List<String> usesPermissions = new ArrayList<>();
    private List<UseFeature> usesFeatures = new ArrayList<>();
    private List<Permission> permissions = new ArrayList<>();
    private List<MetaData> metaDatas = new ArrayList<>();
    private List<String> activity = new ArrayList<>();
    private List<String> receiver = new ArrayList<>();
    private List<String> service = new ArrayList<>();
    private List<String> provider = new ArrayList<>();

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    public Long getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(Long versionCode) {
        this.versionCode = versionCode;
    }

    public String getMinSdkVersion() {
        return minSdkVersion;
    }

    public void setMinSdkVersion(String minSdkVersion) {
        this.minSdkVersion = minSdkVersion;
    }

    public String getTargetSdkVersion() {
        return targetSdkVersion;
    }

    public void setTargetSdkVersion(String targetSdkVersion) {
        this.targetSdkVersion = targetSdkVersion;
    }

    public String getMaxSdkVersion() {
        return maxSdkVersion;
    }

    public void setMaxSdkVersion(String maxSdkVersion) {
        this.maxSdkVersion = maxSdkVersion;
    }

    public List<String> getUsesPermissions() {
        return usesPermissions;
    }

    public void addUsesPermission(String permission) {
        this.usesPermissions.add(permission);
    }

    /**
     * the icon file path in apk
     *
     * @return null if not found
     */
    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     * alias for getLabel
     */
    public String getName() {
        return label;
    }

    /**
     * get the apk's title(name)
     */
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public boolean isAnyDensity() {
        return anyDensity;
    }

    public void setAnyDensity(boolean anyDensity) {
        this.anyDensity = anyDensity;
    }

    public boolean isSmallScreens() {
        return smallScreens;
    }

    public void setSmallScreens(boolean smallScreens) {
        this.smallScreens = smallScreens;
    }

    public boolean isNormalScreens() {
        return normalScreens;
    }

    public void setNormalScreens(boolean normalScreens) {
        this.normalScreens = normalScreens;
    }

    public boolean isLargeScreens() {
        return largeScreens;
    }

    public void setLargeScreens(boolean largeScreens) {
        this.largeScreens = largeScreens;
    }

    public GlEsVersion getGlEsVersion() {
        return glEsVersion;
    }

    public void setGlEsVersion(GlEsVersion glEsVersion) {
        this.glEsVersion = glEsVersion;
    }

    public List<UseFeature> getUsesFeatures() {
        return usesFeatures;
    }

    public String getMetaDate(String name) {
        for (MetaData metaData : getMetaDatas()) {
            if (metaData.getName().equals(name)) return metaData.getValue();
        }
        return "";
    }

    public void addUseFeatures(UseFeature useFeature) {
        this.usesFeatures.add(useFeature);
    }

    public String getInstallLocation() {
        return installLocation;
    }

    public void setInstallLocation(String installLocation) {
        this.installLocation = installLocation;
    }

    public void addPermission(Permission permission) {
        this.permissions.add(permission);
    }

    public void addMetaData(MetaData metaData) {
        this.metaDatas.add(metaData);
    }

    public List<MetaData> getMetaDatas() {
        return metaDatas;
    }

    public void addActivity(String activity) {
        this.activity.add(activity);
    }

    public void addService(String service) {
        this.service.add(service);
    }

    public void addReceiver(String receiver) {
        this.receiver.add(receiver);
    }

    public void addProvider(String provider) {
        this.provider.add(provider);
    }

    public List<String> getActivity() {
        return activity;
    }

    public List<String> getReceiver() {
        return receiver;
    }

    public List<String> getService() {
        return service;
    }

    public List<String> getProvider() {
        return provider;
    }

    public String getFileName() {
        return new File(getFilePath()).getName();
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public long getFileSize() {
        return new File(getFilePath()).length();
    }

    public Flavor getFlavor() {
        return flavor;
    }

    public String getFlavorName() {
        return flavor.getFlavorName(this);
    }

    public void setFlavor(Flavor flavor) {
        this.flavor = flavor;
    }

    @Override
    public String toString() {
        return "packageName: \t" + packageName + "\n"
                + "label: \t" + label + "\n"
                + "icon: \t" + icon + "\n"
                + "versionName: \t" + versionName + "\n"
                + "versionCode: \t" + versionCode + "\n"
                + "minSdkVersion: \t" + minSdkVersion + "\n"
                + "targetSdkVersion: \t" + targetSdkVersion + "\n"
                + "maxSdkVersion: \t" + maxSdkVersion;
    }

}
