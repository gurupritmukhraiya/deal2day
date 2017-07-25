/*
 * Decompiled with CFR 0_101.
 */
package com.mail.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileUtil {
    private static FileUtil fileUtil;

    private FileUtil() {
    }

    public static FileUtil getInstanse() {
        if (fileUtil == null) {
            fileUtil = new FileUtil();
        }
        return fileUtil;
    }

    public byte[] convertFileToByteArray(File file) {
        byte[] attachmentContent = new byte[(int)file.length()];
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            fileInputStream.read(attachmentContent);
            fileInputStream.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return attachmentContent;
    }

    public File convertByteArrayToFile(byte[] byteArray, String fileName) {
        File file = new File(fileName);
        try {
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(byteArray);
            fos.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return file;
    }
}

