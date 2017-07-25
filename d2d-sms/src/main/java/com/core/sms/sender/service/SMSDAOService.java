package com.core.sms.sender.service;

import com.core.sms.sender.service.intf.SMSDAOServiceIntf;
import com.sms.bean.SMSModel;
import com.sms.dao.intf.SMSDAOIntf;
import java.util.List;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class SMSDAOService
extends HibernateDaoSupport
implements SMSDAOServiceIntf {
    private SMSDAOIntf smsDAOIntf;

    public SMSDAOIntf getSmsDAOIntf() {
        return this.smsDAOIntf;
    }

    public void setSmsDAOIntf(SMSDAOIntf smsDAOIntf) {
        this.smsDAOIntf = smsDAOIntf;
    }

    @Override
    public void create(SMSModel smsModel) {
        this.getSmsDAOIntf().create(smsModel);
    }

    @Override
    public SMSModel getSMSById(Long id) {
        return this.getSmsDAOIntf().getSMSById(id);
    }

    @Override
    public List<SMSModel> getAllSMS() {
        return this.getSmsDAOIntf().getAllSMS();
    }

    @Override
    public void update(SMSModel smsModel) {
        this.getSmsDAOIntf().update(smsModel);
    }

    @Override
    public void delete(SMSModel smsModel) {
        this.getSmsDAOIntf().delete(smsModel);
    }

    @Override
    public List<SMSModel> getNumberOfActiveSMS(Integer number) {
        return this.getSmsDAOIntf().getNumberOfActiveSMS(number);
    }

    @Override
    public List<SMSModel> getRangedActiveSMS(Integer start, Integer noOfResult) {
        return this.getSmsDAOIntf().getRangedActiveSMS(start, noOfResult);
    }

    @Override
    public List<SMSModel> getActiveSMS() {
        return this.getSmsDAOIntf().getActiveSMS();
    }

    @Override
    public List<SMSModel> getSentSMS() {
        return this.getSmsDAOIntf().getSentSMS();
    }

    @Override
    public List<SMSModel> getNumberOfSentSMS(Integer number) {
        return this.getSmsDAOIntf().getNumberOfSentSMS(number);
    }

    @Override
    public List<SMSModel> getRangedSentSMS(Integer start, Integer noOfResult) {
        return this.getSmsDAOIntf().getRangedSentSMS(start, noOfResult);
    }
}

