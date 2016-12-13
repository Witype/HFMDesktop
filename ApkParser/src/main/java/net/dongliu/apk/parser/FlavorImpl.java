package net.dongliu.apk.parser;

import net.dongliu.apk.parser.bean.ApkMeta;

/**
 * Created by Typer_work on 2016/11/4.
 */
public class FlavorImpl implements Flavor {

    @Override
    public String getFlavorName(ApkMeta apkMeta) {
        return apkMeta.getMetaDate("UMENG_CHANNEL");
    }
}
