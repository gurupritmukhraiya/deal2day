/*
 * Decompiled with CFR 0_101.
 * 
 * Could not load the following classes:
 *  org.springframework.context.ApplicationContext
 *  org.springframework.context.support.ClassPathXmlApplicationContext
 */
package com.core.sms.sender.service;

import com.core.sms.sender.service.intf.SMSDAOServiceIntf;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SMSDataManager {
    private static ApplicationContext appContext = new ClassPathXmlApplicationContext("SMSCore.xml");

    public static SMSDAOServiceIntf getSMSDAOService() {
        return (SMSDAOServiceIntf)appContext.getBean("smsDAOService");
    }
}

