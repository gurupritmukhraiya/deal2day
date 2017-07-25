package com.core.sms.sender.service.intf;

import com.sms.bean.SMS;

public interface SMSServiceIntf {
	
    public void addSMS(String from, String to, String text);

    public void addSMS(SMS sms);

    public void sendSMS(SMS sms);

    public void sendSMS(String from, String to, String text);

    public void sendSMS(String to, String text);

    public void sendAllActiveSMSFromDB();

    public void sendNumberOfActiveSMSFromDB(Integer var1);

    public void sendRangedActiveSMSFromDB(Integer var1, Integer var2);
}

