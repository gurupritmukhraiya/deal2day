/*
 * Decompiled with CFR 0_101.
 * 
 * Could not load the following classes:
 *  com.d2d.service.templates.MailTemplates
 *  javax.mail.MessagingException
 *  javax.mail.internet.MimeMessage
 *  org.apache.velocity.app.VelocityEngine
 *  org.springframework.context.ApplicationContext
 *  org.springframework.context.support.ClassPathXmlApplicationContext
 *  org.springframework.mail.MailParseException
 *  org.springframework.mail.SimpleMailMessage
 *  org.springframework.mail.javamail.JavaMailSender
 *  org.springframework.mail.javamail.MimeMessageHelper
 *  org.springframework.ui.velocity.VelocityEngineUtils
 */
package com.core.mail.sender.service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.MailParseException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.ui.velocity.VelocityEngineUtils;

import com.mail.bean.Mail;

public class MailSenderCore {
    
	//private static final String ENCODING = "ISO-8859-1";
    private static ApplicationContext context;
    private JavaMailSender mailSender;
    private VelocityEngine velocityEngine;

    public void setVelocityEngine(VelocityEngine velocityEngine) {
        this.velocityEngine = velocityEngine;
    }

    public void setMailSender(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public static MailSenderCore getInstanse() {
        if (context == null) {
            context = new ClassPathXmlApplicationContext("mail-sender-cfg.xml");
        }
        return (MailSenderCore)context.getBean("mailSenderCore");
    }

    public void sendMail(Mail mail) {
        if (mail.getAttachments() == null) {
            this.mailSender.send(this.getSimpleMailMessage(mail));
        } else {
            this.mailSender.send(this.getMimeMailWithAttachment(mail));
        }
    }

    public void sendMail(Mail mail, String templateName, Map<String, Object> objectMap) {
        this.sendMail(mail, null, templateName, objectMap);
    }

    public void sendMail(Mail mail, String templatePath, String templateName, Map<String, Object> objectMap) {
        this.velocityEngine = templatePath != null ? this.getNewVelocityEngine(templatePath) : this.getNewVelocityEngine();
        String template = VelocityEngineUtils.mergeTemplateIntoString((VelocityEngine)this.velocityEngine, (String)templateName, (String)"ISO-8859-1", objectMap);
        this.mailSender.send(this.getTemplateMessage(mail, template));
    }

    private SimpleMailMessage getSimpleMailMessage(Mail mail) {
        SimpleMailMessage simpleMail = new SimpleMailMessage();
        simpleMail.setFrom(mail.getFrom());
        simpleMail.setTo(mail.getTo());
        simpleMail.setSubject(mail.getSubject());
        simpleMail.setText(new String(mail.getBody()));
        return simpleMail;
    }

    private MimeMessage getMimeMailWithAttachment(Mail mail) {
        MimeMessage message = this.mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(mail.getFrom());
            helper.setTo(mail.getTo());
            helper.setSubject(mail.getSubject());
            helper.setText(new String(mail.getBody()));
            List<File> attachments = mail.getAttachments();
            for (File attachment : attachments) {
                helper.addAttachment(attachment.getName(), attachment);
            }
        }
        catch (MessagingException e) {
            throw new MailParseException((Throwable)e);
        }
        return message;
    }

    private MimeMessage getTemplateMessage(Mail mail, String template) {
        MimeMessage message = this.mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(mail.getFrom());
            helper.setTo(mail.getTo());
            helper.setSubject(mail.getSubject());
            helper.setText(template, true);
        }
        catch (MessagingException e) {
            throw new MailParseException((Throwable)e);
        }
        return message;
    }

    private VelocityEngine getNewVelocityEngine(String templatePath) {
        Properties velocityProperty = new Properties();
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("VelocityTemplate.properties");
        try {
            velocityProperty.load(inputStream);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        this.velocityEngine = new VelocityEngine(velocityProperty);
        this.velocityEngine.setProperty("file.resource.loader.path", (Object)templatePath);
        this.velocityEngine.init();
        return this.velocityEngine;
    }

    private VelocityEngine getNewVelocityEngine() {
        Properties velocityProperty = new Properties();
        velocityProperty.put("resource.loader", "class");
        velocityProperty.put("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        this.velocityEngine = new VelocityEngine(velocityProperty);
        this.velocityEngine.init();
        return this.velocityEngine;
    }
}

