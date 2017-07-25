/*
 * Decompiled with CFR 0_101.
 */
package com.core.mail.sender.service;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.core.mail.sender.service.intf.MailDBServiceIntf;
import com.core.mail.sender.service.intf.MailServiceIntf;
import com.mail.bean.Mail;

public class MailService
implements MailServiceIntf {
    private static MailService mailService;
    private MailDBServiceIntf mailDBService = MailDBService.getInstanse();
    private MailSenderCore mailSenderCore = MailSenderCore.getInstanse();

    private MailService() {
        new com.mail.scheduler.MailSenderScheduler();
    }

    public static MailService getInstanse() {
        if (mailService == null) {
            mailService = new MailService();
        }
        return mailService;
    }

    @Override
    public void addMail(String from, String to, String subject, String body) {
        this.addMail(new Mail(from, to, subject, body.getBytes(), null));
    }

    @Override
    public void addMail(String from, String to, String subject, String body, List<File> attachment) {
        this.addMail(new Mail(from, to, subject, body.getBytes(), attachment));
    }

    @Override
    public void addMail(String from, String to, String subject, byte[] body) {
        this.addMail(new Mail(from, to, subject, body, null));
    }

    @Override
    public void addMail(String from, String to, String subject, byte[] body, List<File> attachment) {
        this.addMail(new Mail(from, to, subject, body, attachment));
    }

    @Override
    public void addMail(Mail mail) {
        mail.setStatus("A");
        mail.setCreatedDate(new Date());
        this.mailDBService.create(mail);
    }

    @Override
    public void sendMail(String from, String to, String subject, String body) {
        this.sendMail(new Mail(from, to, subject, body.getBytes(), null));
    }

    @Override
    public void sendMail(String from, String to, String subject, String body, List<File> attachment) {
        this.sendMail(new Mail(from, to, subject, body.getBytes(), attachment));
    }

    @Override
    public void sendMail(String from, String to, String subject, byte[] body) {
        this.sendMail(new Mail(from, to, subject, body, null));
    }

    @Override
    public void sendMail(String from, String to, String subject, byte[] body, List<File> attachment) {
        this.sendMail(new Mail(from, to, subject, body, attachment));
    }

    @Override
    public void sendMail(Mail mail) {
        this.mailSenderCore.sendMail(mail);
    }

    @Override
    public void sendAllActiveMailsFromDB() {
        List<Mail> mails = this.mailDBService.getActiveMails();
        for (Mail mail : mails) {
            this.sendMail(mail);
        }
    }

    @Override
    public void sendNumberOfActiveMailsFromDB(Integer number) {
        List<Mail> mails = this.mailDBService.getNumberOfActiveMails(number);
        for (Mail mail : mails) {
            this.sendMail(mail);
        }
    }

    @Override
    public void sendRangedActiveMailsFromDB(Integer startFrom, Integer noOfRows) {
        List<Mail> mails = this.mailDBService.getRangedActiveMails(startFrom, noOfRows);
        for (Mail mail : mails) {
            this.sendMail(mail);
        }
    }

	@Override
	public void sendMail(Mail mail, String templatePath, String templateName, Map<String, Object> objectMap) {
		mailSenderCore.sendMail(mail, templatePath, templateName, objectMap);		
	}
}

