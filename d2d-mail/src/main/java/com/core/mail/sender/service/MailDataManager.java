/*
 * Decompiled with CFR 0_101.
 * 
 * Could not load the following classes:
 *  org.springframework.context.ApplicationContext
 *  org.springframework.context.support.ClassPathXmlApplicationContext
 */
package com.core.mail.sender.service;

import com.core.mail.sender.service.intf.MailDAOServiceIntf;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MailDataManager {
    private static ApplicationContext appContext = new ClassPathXmlApplicationContext("MailCore.xml");

    public static MailDAOServiceIntf getMailDAOService() {
        return (MailDAOServiceIntf)appContext.getBean("mailDAOService");
    }
}

