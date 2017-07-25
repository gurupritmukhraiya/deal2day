/*
 * Decompiled with CFR 0_101.
 */
package com.sms.dao.intf;

import com.sms.bean.SMSModel;
import java.util.List;

public interface SMSDAOIntf {
    public void create(SMSModel var1);

    public SMSModel getSMSById(Long var1);

    public List<SMSModel> getAllSMS();

    public List<SMSModel> getNumberOfActiveSMS(Integer var1);

    public List<SMSModel> getRangedActiveSMS(Integer var1, Integer var2);

    public List<SMSModel> getActiveSMS();

    public List<SMSModel> getSentSMS();

    public List<SMSModel> getNumberOfSentSMS(Integer var1);

    public List<SMSModel> getRangedSentSMS(Integer var1, Integer var2);

    public void update(SMSModel var1);

    public void delete(SMSModel var1);
}

