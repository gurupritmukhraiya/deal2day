/*
 * Decompiled with CFR 0_101.
 * 
 * Could not load the following classes:
 *  org.springframework.context.support.ClassPathXmlApplicationContext
 */
package com.mail.test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.core.mail.sender.service.MailSenderCore;
import com.core.mail.sender.service.MailService;
import com.mail.bean.Mail;

public class Test {
    public static void main(String[] args) {
        Mail mail = new Mail();
       // mail.addAttachment(new File("C:\\D2D\\DATAHOME\\mer\\1\\34\\default.jpg"));
       //mail.addAttachment(new File("C:\\D2D\\DATAHOME\\mer\\1\\34\\t_cover.jpg"));
        mail.setBody(new String("").getBytes());
        mail.setFrom("lalit@deal2day.in");
        mail.setTo("mayank17sept@gmail.com");
        mail.setSubject("mysubject");
        mail.setStatus("A");
        mail.setCreatedDate(new Date());
        MailService.getInstanse().addMail(mail);
        
        System.out.println(mail.getMailId());

       // MailService.getInstanse().sendMail(mail);
        
        
        Map<String, Object> objectMap = new HashMap<String, Object>();
        objectMap.put("firstName", "Guru");
        objectMap.put("lastName", "Mukhraiya");
        objectMap.put("location", "Baner");
        
		MailService.getInstanse().sendMail(mail, "C:\\", "emailtemplate.vm", objectMap );
    }
}

