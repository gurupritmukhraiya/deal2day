/*
 * Decompiled with CFR 0_101.
 */
package com.mail.dao.intf;

import com.mail.bean.MailModel;
import java.util.List;

public interface MailDAOIntf {
    public void create(MailModel var1);

    public MailModel getMailById(Long var1);

    public List<MailModel> getMails();

    public List<MailModel> getNumberOfActiveMails(Integer var1);

    public List<MailModel> getRangedActiveMails(Integer var1, Integer var2);

    public List<MailModel> getActiveMails();

    public List<MailModel> getSentMails();

    public List<MailModel> getNumberOfSentMails(Integer var1);

    public List<MailModel> getRangedSentMails(Integer var1, Integer var2);

    public void update(MailModel var1);

    public void delete(MailModel var1);
}

