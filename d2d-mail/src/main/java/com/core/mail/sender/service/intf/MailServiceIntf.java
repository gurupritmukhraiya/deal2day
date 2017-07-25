/*
 * Decompiled with CFR 0_101.
 */
package com.core.mail.sender.service.intf;

import com.mail.bean.Mail;

import java.io.File;
import java.util.List;
import java.util.Map;

public interface MailServiceIntf {
    public void addMail(String var1, String var2, String var3, String var4);

    public void addMail(String var1, String var2, String var3, String var4, List<File> var5);

    public void addMail(String var1, String var2, String var3, byte[] var4);

    public void addMail(String var1, String var2, String var3, byte[] var4, List<File> var5);

    public void addMail(Mail var1);

    public void sendMail(Mail var1);

    public void sendMail(String var1, String var2, String var3, String var4);
    
    public void sendMail(Mail mail, String templatePath, String templateName, Map<String, Object> objectMap);

    public void sendMail(String var1, String var2, String var3, String var4, List<File> var5);

    public void sendMail(String var1, String var2, String var3, byte[] var4);

    public void sendMail(String var1, String var2, String var3, byte[] var4, List<File> var5);

    public void sendAllActiveMailsFromDB();

    public void sendNumberOfActiveMailsFromDB(Integer var1);

    public void sendRangedActiveMailsFromDB(Integer var1, Integer var2);
}

