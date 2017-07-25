/*
 * Decompiled with CFR 0_101.
 */
package com.sms.util;

import com.sms.bean.SMS;
import com.sms.bean.SMSModel;
import java.util.Date;

public class SMSCovertor {
    private static SMSCovertor smsCovertor;

    private SMSCovertor() {
    }

    public static SMSCovertor getInstanse() {
        if (smsCovertor == null) {
            smsCovertor = new SMSCovertor();
        }
        return smsCovertor;
    }

    public SMSModel convertSMSToSMSModel(SMS sms) {
        SMSModel smsModel = null;
        if (sms != null) {
            smsModel = new SMSModel();
            smsModel.setFrom(sms.getFrom());
            smsModel.setStatus(sms.getStatus());
            smsModel.setText(sms.getText());
            smsModel.setTo(sms.getTo());
            smsModel.setCreatedDate(sms.getCreatedDate());
        }
        return smsModel;
    }

    public SMS convertSMSModelToSMS(SMSModel smsModel) {
        SMS sms = null;
        if (smsModel != null) {
            sms = new SMS();
            sms.setFrom(smsModel.getFrom());
            sms.setStatus(smsModel.getStatus());
            sms.setText(smsModel.getText());
            sms.setTo(smsModel.getTo());
            sms.setCreatedDate(smsModel.getCreatedDate());
            sms.setSmsId(smsModel.getSmsId());
        }
        return sms;
    }
}

