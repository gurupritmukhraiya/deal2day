/*
 * Decompiled with CFR 0_101.
 */
package com.core.mail.sender.service;

import com.core.mail.sender.service.MailDataManager;
import com.core.mail.sender.service.intf.MailDAOServiceIntf;
import com.core.mail.sender.service.intf.MailDBServiceIntf;
import com.mail.bean.Mail;
import com.mail.bean.MailModel;
import com.mail.util.MailCovertor;
import java.util.LinkedList;
import java.util.List;

public class MailDBService
implements MailDBServiceIntf {
    private MailCovertor mailUtil = MailCovertor.getInstanse();
    private MailDAOServiceIntf mailDAOServiceIntf = MailDataManager.getMailDAOService();
    private static MailDBService mailDBService;

    private MailDBService() {
    }

    public static MailDBService getInstanse() {
        if (mailDBService == null) {
            mailDBService = new MailDBService();
        }
        return mailDBService;
    }

    @Override
    public void create(Mail mail) {
        this.mailDAOServiceIntf.create(this.mailUtil.convertMailToMailModel(mail));
    }

    @Override
    public Mail getMailById(Long id) {
        return this.mailUtil.convertMailModelToMail(this.mailDAOServiceIntf.getMailById(id));
    }

    @Override
    public List<Mail> getMails() {
        LinkedList<Mail> mails = new LinkedList<Mail>();
        List<MailModel> mailModels = this.mailDAOServiceIntf.getMails();
        for (MailModel mailModel : mailModels) {
            mails.add(this.mailUtil.convertMailModelToMail(mailModel));
        }
        return mails;
    }

    @Override
    public void update(Mail mail) {
        this.mailDAOServiceIntf.update(this.mailUtil.convertMailToMailModel(mail));
    }

    @Override
    public void delete(Mail mail) {
        this.mailDAOServiceIntf.delete(this.mailUtil.convertMailToMailModel(mail));
    }

    @Override
    public List<Mail> getActiveMails() {
        LinkedList<Mail> mails = new LinkedList<Mail>();
        List<MailModel> mailModels = this.mailDAOServiceIntf.getActiveMails();
        for (MailModel mailModel : mailModels) {
            mails.add(this.mailUtil.convertMailModelToMail(mailModel));
        }
        return mails;
    }

    @Override
    public List<Mail> getSentMails() {
        LinkedList<Mail> mails = new LinkedList<Mail>();
        List<MailModel> mailModels = this.mailDAOServiceIntf.getSentMails();
        for (MailModel mailModel : mailModels) {
            mails.add(this.mailUtil.convertMailModelToMail(mailModel));
        }
        return mails;
    }

    @Override
    public List<Mail> getNumberOfActiveMails(Integer number) {
        LinkedList<Mail> mails = new LinkedList<Mail>();
        List<MailModel> mailModels = this.mailDAOServiceIntf.getNumberOfActiveMails(number);
        for (MailModel mailModel : mailModels) {
            mails.add(this.mailUtil.convertMailModelToMail(mailModel));
        }
        return mails;
    }

    @Override
    public List<Mail> getRangedActiveMails(Integer start, Integer noOfResult) {
        LinkedList<Mail> mails = new LinkedList<Mail>();
        List<MailModel> mailModels = this.mailDAOServiceIntf.getRangedActiveMails(start, noOfResult);
        for (MailModel mailModel : mailModels) {
            mails.add(this.mailUtil.convertMailModelToMail(mailModel));
        }
        return mails;
    }

    @Override
    public List<Mail> getNumberOfSentMails(Integer number) {
        LinkedList<Mail> mails = new LinkedList<Mail>();
        List<MailModel> mailModels = this.mailDAOServiceIntf.getNumberOfSentMails(number);
        for (MailModel mailModel : mailModels) {
            mails.add(this.mailUtil.convertMailModelToMail(mailModel));
        }
        return mails;
    }

    @Override
    public List<Mail> getRangedSentMails(Integer start, Integer noOfResult) {
        LinkedList<Mail> mails = new LinkedList<Mail>();
        List<MailModel> mailModels = this.mailDAOServiceIntf.getRangedSentMails(start, noOfResult);
        for (MailModel mailModel : mailModels) {
            mails.add(this.mailUtil.convertMailModelToMail(mailModel));
        }
        return mails;
    }
}

