package net.dongliu.apk.parser;

import net.dongliu.apk.parser.bean.ApkMeta;
import net.dongliu.apk.parser.bean.MetaData;
import net.dongliu.apk.parser.bean.UseFeature;

import java.io.IOException;
import java.security.cert.CertificateException;
import java.util.Locale;

/**
 * Main method for parser apk
 *
 * @author Liu Dong {@literal <im@dongliu.net>}
 */
public class Main {
    public static void main(String[] args) throws IOException, CertificateException {
        try (ApkParser parser = new ApkParser("E:\\AppVersionDown\\apk\\mi\\version\\upark1.8.7.326_mi.apk")) {
            parser.setPreferredLocale(Locale.getDefault());
            ApkMeta apkMeta = parser.getApkMeta();
            System.out.println(apkMeta.getLabel());
            System.out.println(apkMeta.getPackageName());
            System.out.println(apkMeta.getVersionCode());
            parser.close();
        }
    }
}
