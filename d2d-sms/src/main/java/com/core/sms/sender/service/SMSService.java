package com.core.sms.sender.service;

import java.util.Date;
import java.util.List;

import com.core.sms.sender.service.intf.SMSServiceIntf;
import com.sms.bean.SMS;

public class SMSService implements SMSServiceIntf {
	
    private static SMSService smsService;
    private SMSDBService smsDBService = SMSDBService.getInstanse();
    private SMSSenderCore smsSenderCore = SMSSenderCore.getInstanse();

    private SMSService() {
        new com.sms.scheduler.SMSSenderScheduler();
    }

    public static SMSService getInstanse() {
        if (smsService == null) {
            smsService = new SMSService();
        }
        return smsService;
    }

    @Override
    public void addSMS(String from, String to, String text) {
        this.addSMS(new SMS(from, to, text));
    }

    @Override
    public void addSMS(SMS sms) {
        sms.setStatus("A");
        sms.setCreatedDate(new Date());
        this.smsDBService.create(sms);
    }

    @Override
    public void sendSMS(SMS sms) {
        this.smsSenderCore.sendSMS(sms);
    }

    @Override
    public void sendSMS(String from, String to, String text) {
        this.sendSMS(new SMS(from, to, text));
    }

    @Override
    public void sendSMS(String to, String text) {
        this.sendSMS(new SMS(null, to, text));
    }

    @Override
    public void sendAllActiveSMSFromDB() {
        List<SMS> smsList = this.smsDBService.getActiveSMS();
        for (SMS sms : smsList) {
            this.sendSMS(sms);
        }
    }

    @Override
    public void sendNumberOfActiveSMSFromDB(Integer number) {
        List<SMS> smsList = this.smsDBService.getNumberOfActiveSMS(number);
        for (SMS sms : smsList) {
            this.sendSMS(sms);
        }
    }

    @Override
    public void sendRangedActiveSMSFromDB(Integer startFrom, Integer noOfRows) {
        List<SMS> smsList = this.smsDBService.getRangedActiveSMS(startFrom, noOfRows);
        for (SMS sms : smsList) {
            this.sendSMS(sms);
        }
    }
}

