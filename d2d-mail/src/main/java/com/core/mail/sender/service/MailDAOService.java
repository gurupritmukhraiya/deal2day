/*
 * Decompiled with CFR 0_101.
 * 
 * Could not load the following classes:
 *  org.springframework.orm.hibernate3.support.HibernateDaoSupport
 */
package com.core.mail.sender.service;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.core.mail.sender.service.intf.MailDAOServiceIntf;
import com.mail.bean.MailModel;
import com.mail.dao.intf.MailDAOIntf;

public class MailDAOService extends HibernateDaoSupport implements MailDAOServiceIntf {
    private MailDAOIntf mailDAOIntf;

    public MailDAOIntf getMailDAOIntf() {
        return this.mailDAOIntf;
    }

    public void setMailDAOIntf(MailDAOIntf mailDAOIntf) {
        this.mailDAOIntf = mailDAOIntf;
    }

    @Override
    public void create(MailModel mailModel) {
        this.getMailDAOIntf().create(mailModel);
    }

    @Override
    public MailModel getMailById(Long id) {
        return this.getMailDAOIntf().getMailById(id);
    }

    @Override
    public List<MailModel> getMails() {
        return this.getMailDAOIntf().getMails();
    }

    @Override
    public void update(MailModel mailModel) {
        this.getMailDAOIntf().update(mailModel);
    }

    @Override
    public void delete(MailModel mailModel) {
        this.getMailDAOIntf().delete(mailModel);
    }

    @Override
    public List<MailModel> getActiveMails() {
        return this.getMailDAOIntf().getActiveMails();
    }

    @Override
    public List<MailModel> getSentMails() {
        return this.getMailDAOIntf().getSentMails();
    }

    @Override
    public List<MailModel> getNumberOfActiveMails(Integer number) {
        return this.getMailDAOIntf().getNumberOfActiveMails(number);
    }

    @Override
    public List<MailModel> getRangedActiveMails(Integer start, Integer noOfResult) {
        return this.getMailDAOIntf().getRangedActiveMails(start, noOfResult);
    }

    @Override
    public List<MailModel> getNumberOfSentMails(Integer number) {
        return this.getMailDAOIntf().getNumberOfSentMails(number);
    }

    @Override
    public List<MailModel> getRangedSentMails(Integer start, Integer noOfResult) {
        return this.getMailDAOIntf().getRangedSentMails(start, noOfResult);
    }
}

