package com.witype.easyamigo;

import javax.swing.*;
import java.io.*;
import java.util.Locale;

/**
 * Created by Typer_work on 2016/9/28 0028.
 */
public class FileUtil {

    private static String MESSAGE = "";

    /**
     * ���Ƶ����ļ�
     *
     * @param srcFileName
     *            �����Ƶ��ļ���
     * @param destFileName
     *            Ŀ���ļ���
     * @param overlay
     *            ���Ŀ���ļ����ڣ��Ƿ񸲸�
     * @return ������Ƴɹ�����true�����򷵻�false
     */
    public static boolean copyFile(String srcFileName, String destFileName, boolean overlay) {
        File srcFile = new File(srcFileName);

        // �ж�Դ�ļ��Ƿ����
        if (!srcFile.exists()) {
            MESSAGE = "Դ�ļ���" + srcFileName + "�����ڣ�";
            JOptionPane.showMessageDialog(null, MESSAGE);
            return false;
        } else if (!srcFile.isFile()) {
            MESSAGE = "�����ļ�ʧ�ܣ�Դ�ļ���" + srcFileName + "����һ���ļ���";
            JOptionPane.showMessageDialog(null, MESSAGE);
            return false;
        }

        // �ж�Ŀ���ļ��Ƿ����
        File destFile = new File(destFileName);
        if (destFile.exists()) {
            // ���Ŀ���ļ����ڲ�������
            if (overlay) {
                // ɾ���Ѿ����ڵ�Ŀ���ļ�������Ŀ���ļ���Ŀ¼���ǵ����ļ�
                new File(destFileName).delete();
            }
        } else {
            // ���Ŀ���ļ�����Ŀ¼�����ڣ��򴴽�Ŀ¼
            if (!destFile.getParentFile().exists()) {
                // Ŀ���ļ�����Ŀ¼������
                if (!destFile.getParentFile().mkdirs()) {
                    // �����ļ�ʧ�ܣ�����Ŀ���ļ�����Ŀ¼ʧ��
                    return false;
                }
            }
        }

        // �����ļ�
        int byteread = 0; // ��ȡ���ֽ���
        InputStream in = null;
        OutputStream out = null;

        try {
            in = new FileInputStream(srcFile);
            out = new FileOutputStream(destFile);
            byte[] buffer = new byte[1024];

            while ((byteread = in.read(buffer)) != -1) {
                out.write(buffer, 0, byteread);
            }
            return true;
        } catch (FileNotFoundException e) {
            return false;
        } catch (IOException e) {
            return false;
        } finally {
            try {
                if (out != null) out.close();
                if (in != null) in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * ��������Ŀ¼������
     *
     * @param srcDirName
     *            ������Ŀ¼��Ŀ¼��
     * @param destDirName
     *            Ŀ��Ŀ¼��
     * @param overlay
     *            ���Ŀ��Ŀ¼���ڣ��Ƿ񸲸�
     * @return ������Ƴɹ�����true�����򷵻�false
     */
    public static boolean copyDirectory(String srcDirName, String destDirName,
                                        boolean overlay) {
        // �ж�ԴĿ¼�Ƿ����
        File srcDir = new File(srcDirName);
        if (!srcDir.exists()) {
            MESSAGE = "����Ŀ¼ʧ�ܣ�ԴĿ¼" + srcDirName + "�����ڣ�";
            JOptionPane.showMessageDialog(null, MESSAGE);
            return false;
        } else if (!srcDir.isDirectory()) {
            MESSAGE = "����Ŀ¼ʧ�ܣ�" + srcDirName + "����Ŀ¼��";
            JOptionPane.showMessageDialog(null, MESSAGE);
            return false;
        }

        // ���Ŀ��Ŀ¼���������ļ��ָ�����β��������ļ��ָ���
        if (!destDirName.endsWith(File.separator)) {
            destDirName = destDirName + File.separator;
        }
        File destDir = new File(destDirName);
        // ���Ŀ���ļ��д���
        if (destDir.exists()) {
            // �����������ɾ���Ѵ��ڵ�Ŀ��Ŀ¼
            if (overlay) {
                new File(destDirName).delete();
            } else {
                MESSAGE = "����Ŀ¼ʧ�ܣ�Ŀ��Ŀ¼" + destDirName + "�Ѵ��ڣ�";
                JOptionPane.showMessageDialog(null, MESSAGE);
                return false;
            }
        } else {
            // ����Ŀ��Ŀ¼
            System.out.println("Ŀ��Ŀ¼�����ڣ�׼������������");
            if (!destDir.mkdirs()) {
                System.out.println("����Ŀ¼ʧ�ܣ�����Ŀ��Ŀ¼ʧ�ܣ�");
                return false;
            }
        }

        boolean flag = true;
        File[] files = srcDir.listFiles();
        for (int i = 0; i < files.length; i++) {
            // �����ļ�
            if (files[i].isFile()) {
                flag = FileUtil.copyFile(files[i].getAbsolutePath(),
                        destDirName + files[i].getName(), overlay);
                if (!flag)
                    break;
            } else if (files[i].isDirectory()) {
                flag = FileUtil.copyDirectory(files[i].getAbsolutePath(),
                        destDirName + files[i].getName(), overlay);
                if (!flag)
                    break;
            }
        }
        if (!flag) {
            MESSAGE = "����Ŀ¼" + srcDirName + "��" + destDirName + "ʧ�ܣ�";
            JOptionPane.showMessageDialog(null, MESSAGE);
            return false;
        } else {
            return true;
        }
    }

    public static String convertFileSize(String filePath) {
        File file = new File(filePath);
        if (file.isDirectory() || !file.exists()) return "0kb";
        long size = file.length();
        long kb = 1024;
        long mb = kb * 1024;
        long gb = mb * 1024;
        if (size >= gb) {
            return String.format(Locale.CHINA, "%.2f GB", (float) size / gb);
        } else if (size >= mb) {
            float f = (float) size / mb;
            return String.format(f > 100 ? "%.0f MB" : "%.2f MB", f);
        } else if (size >= kb) {
            float f = (float) size / kb;
            return String.format(f > 100 ? "%.0f KB" : "%.1f KB", f);
        } else
            return String.format(Locale.CHINA, "%d B", size);
    }
}
