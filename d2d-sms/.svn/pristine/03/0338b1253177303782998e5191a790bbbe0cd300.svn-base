/*
 * Decompiled with CFR 0_101.
 */
package com.core.sms.sender.service;

import com.core.sms.sender.service.SMSDataManager;
import com.core.sms.sender.service.intf.SMSDAOServiceIntf;
import com.core.sms.sender.service.intf.SMSDBServiceIntf;
import com.sms.bean.SMS;
import com.sms.bean.SMSModel;
import com.sms.util.SMSCovertor;
import java.util.LinkedList;
import java.util.List;

public class SMSDBService
implements SMSDBServiceIntf {
    private SMSCovertor smsUtil = SMSCovertor.getInstanse();
    private SMSDAOServiceIntf smsDAOServiceIntf = SMSDataManager.getSMSDAOService();
    private static SMSDBService smsDBService;

    private SMSDBService() {
    }

    public static SMSDBService getInstanse() {
        if (smsDBService == null) {
            smsDBService = new SMSDBService();
        }
        return smsDBService;
    }

    @Override
    public void create(SMS sms) {
        this.smsDAOServiceIntf.create(this.smsUtil.convertSMSToSMSModel(sms));
    }

    @Override
    public SMS getSMSById(Long id) {
        return this.smsUtil.convertSMSModelToSMS(this.smsDAOServiceIntf.getSMSById(id));
    }

    @Override
    public List<SMS> getAllSMS() {
        LinkedList<SMS> smsList = new LinkedList<SMS>();
        List<SMSModel> smsModels = this.smsDAOServiceIntf.getAllSMS();
        for (SMSModel smsModel : smsModels) {
            smsList.add(this.smsUtil.convertSMSModelToSMS(smsModel));
        }
        return smsList;
    }

    @Override
    public void update(SMS sms) {
        this.smsDAOServiceIntf.update(this.smsUtil.convertSMSToSMSModel(sms));
    }

    @Override
    public void delete(SMS sms) {
        this.smsDAOServiceIntf.delete(this.smsUtil.convertSMSToSMSModel(sms));
    }

    @Override
    public List<SMS> getNumberOfActiveSMS(Integer number) {
        LinkedList<SMS> smsList = new LinkedList<SMS>();
        List<SMSModel> smsModels = this.smsDAOServiceIntf.getNumberOfActiveSMS(number);
        for (SMSModel smsModel : smsModels) {
            smsList.add(this.smsUtil.convertSMSModelToSMS(smsModel));
        }
        return smsList;
    }

    @Override
    public List<SMS> getRangedActiveSMS(Integer start, Integer noOfResult) {
        LinkedList<SMS> smsList = new LinkedList<SMS>();
        List<SMSModel> smsModels = this.smsDAOServiceIntf.getRangedActiveSMS(start, noOfResult);
        for (SMSModel smsModel : smsModels) {
            smsList.add(this.smsUtil.convertSMSModelToSMS(smsModel));
        }
        return smsList;
    }

    @Override
    public List<SMS> getActiveSMS() {
        LinkedList<SMS> smsList = new LinkedList<SMS>();
        List<SMSModel> smsModels = this.smsDAOServiceIntf.getActiveSMS();
        for (SMSModel smsModel : smsModels) {
            smsList.add(this.smsUtil.convertSMSModelToSMS(smsModel));
        }
        return smsList;
    }

    @Override
    public List<SMS> getSentSMS() {
        LinkedList<SMS> smsList = new LinkedList<SMS>();
        List<SMSModel> smsModels = this.smsDAOServiceIntf.getSentSMS();
        for (SMSModel smsModel : smsModels) {
            smsList.add(this.smsUtil.convertSMSModelToSMS(smsModel));
        }
        return smsList;
    }

    @Override
    public List<SMS> getNumberOfSentSMS(Integer number) {
        LinkedList<SMS> smsList = new LinkedList<SMS>();
        List<SMSModel> smsModels = this.smsDAOServiceIntf.getNumberOfSentSMS(number);
        for (SMSModel smsModel : smsModels) {
            smsList.add(this.smsUtil.convertSMSModelToSMS(smsModel));
        }
        return smsList;
    }

    @Override
    public List<SMS> getRangedSentSMS(Integer start, Integer noOfResult) {
        LinkedList<SMS> smsList = new LinkedList<SMS>();
        List<SMSModel> smsModels = this.smsDAOServiceIntf.getRangedSentSMS(start, noOfResult);
        for (SMSModel smsModel : smsModels) {
            smsList.add(this.smsUtil.convertSMSModelToSMS(smsModel));
        }
        return smsList;
    }
}

