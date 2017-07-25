package com.d2d.service.util;

import java.util.Random;

public class VerificationUtil {
    private static final String ALPHA_NUM = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static String getAlphaNumeric(int len) {
        StringBuffer sb = new StringBuffer(len);
        for (int i = 0; i < len; ++i) {
            int ndx = (int)(Math.random() * (double)ALPHA_NUM.length());
            sb.append(ALPHA_NUM.charAt(ndx));
        }
        return sb.toString();
    }

    public static String genrateVerificationCode() {
        Random r = new Random(System.currentTimeMillis());
        return new Integer((1 + r.nextInt(2)) * 10000 + r.nextInt(10000)).toString();
    }

    public static void main(String[] args) {
        System.out.println(VerificationUtil.getAlphaNumeric(5));
    }
}

