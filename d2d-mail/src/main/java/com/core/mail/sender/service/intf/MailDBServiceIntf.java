/*
 * Decompiled with CFR 0_101.
 */
package com.core.mail.sender.service.intf;

import com.mail.bean.Mail;
import java.util.List;

public interface MailDBServiceIntf {
    public void create(Mail var1);

    public Mail getMailById(Long var1);

    public List<Mail> getMails();

    public List<Mail> getNumberOfActiveMails(Integer var1);

    public List<Mail> getRangedActiveMails(Integer var1, Integer var2);

    public List<Mail> getActiveMails();

    public List<Mail> getSentMails();

    public List<Mail> getNumberOfSentMails(Integer var1);

    public List<Mail> getRangedSentMails(Integer var1, Integer var2);

    public void update(Mail var1);

    public void delete(Mail var1);
}

