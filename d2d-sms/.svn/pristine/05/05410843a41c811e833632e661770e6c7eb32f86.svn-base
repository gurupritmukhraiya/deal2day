/*
 * Decompiled with CFR 0_101.
 * 
 * Could not load the following classes:
 *  org.springframework.context.support.ClassPathXmlApplicationContext
 */
package com.sms.test;

import com.core.sms.sender.service.SMSDBService;
import com.sms.bean.SMS;
import java.util.Date;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        SMS sms = new SMS();
        sms.setFrom("9890728332");
        sms.setTo("989023232");
        sms.setStatus("A");
        sms.setText("Hw R U Sent ??");
        sms.setCreatedDate(new Date());
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("SMSCore.xml");
        SMSDBService service = SMSDBService.getInstanse();
        service.create(sms);
    }
}

