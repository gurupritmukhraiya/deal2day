package com.sms.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.sms.bean.SMSModel;
import com.sms.dao.intf.SMSDAOIntf;

public class SMSDAO extends HibernateDaoSupport implements SMSDAOIntf {
    private Session session;

    public SMSDAO() {
    }

    public SMSDAO(Session session) {
        this.session = session;
    }

    public Session getHibernateSession() {
        if (this.session != null && this.session.isOpen()) {
            return this.session;
        }
        this.session = super.getSession();
        return this.session;
    }

    @Override
    public void create(SMSModel smsModel) {
        try {
            this.getHibernateSession().saveOrUpdate((Object)smsModel);
        }
        catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public SMSModel getSMSById(Long id) {
        SMSModel smsModel = null;
        try {
            smsModel = (SMSModel)this.getHibernateSession().load((Class)SMSModel.class, (Serializable)id);
        }
        catch (HibernateException e) {
            e.printStackTrace();
        }
        return smsModel;
    }

    @Override
    public List<SMSModel> getAllSMS() {
        List smsModels = null;
        try {
            smsModels = this.getHibernateSession().createCriteria((Class)SMSModel.class).list();
        }
        catch (HibernateException e) {
            e.printStackTrace();
        }
        return smsModels;
    }

    @Override
    public void update(SMSModel smsModel) {
        try {
            this.getHibernateSession().saveOrUpdate((Object)smsModel);
        }
        catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(SMSModel smsModel) {
        try {
            this.getHibernateSession().delete((Object)smsModel);
        }
        catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<SMSModel> getActiveSMS() {
        List smsModels = null;
        try {
            Criteria criteria = this.getHibernateSession().createCriteria((Class)SMSModel.class).add((Criterion)Restrictions.eq((String)"status", (Object)"A"));
            smsModels = criteria.list();
        }
        catch (HibernateException e) {
            e.printStackTrace();
        }
        return smsModels;
    }

    @Override
    public List<SMSModel> getNumberOfActiveSMS(Integer number) {
        List smsModels = null;
        try {
            Criteria criteria = this.getHibernateSession().createCriteria((Class)SMSModel.class).add((Criterion)Restrictions.eq((String)"status", (Object)"A"));
            criteria.setMaxResults(number.intValue());
            smsModels = criteria.list();
        }
        catch (HibernateException e) {
            e.printStackTrace();
        }
        return smsModels;
    }

    @Override
    public List<SMSModel> getRangedActiveSMS(Integer start, Integer noOfResult) {
        List smsModels = null;
        try {
            Criteria criteria = this.getHibernateSession().createCriteria((Class)SMSModel.class).add((Criterion)Restrictions.eq((String)"status", (Object)"A"));
            criteria.setMaxResults(noOfResult.intValue());
            criteria.setFirstResult(start.intValue());
            smsModels = criteria.list();
        }
        catch (HibernateException e) {
            e.printStackTrace();
        }
        return smsModels;
    }

    @Override
    public List<SMSModel> getSentSMS() {
        List smsModels = null;
        try {
            Criteria criteria = this.getHibernateSession().createCriteria((Class)SMSModel.class).add((Criterion)Restrictions.eq((String)"status", (Object)"Sent"));
            smsModels = criteria.list();
        }
        catch (HibernateException e) {
            e.printStackTrace();
        }
        return smsModels;
    }

    @Override
    public List<SMSModel> getNumberOfSentSMS(Integer number) {
        List smsModels = null;
        try {
            Criteria criteria = this.getHibernateSession().createCriteria((Class)SMSModel.class).add((Criterion)Restrictions.eq((String)"status", (Object)"Sent"));
            criteria.setMaxResults(number.intValue());
            smsModels = criteria.list();
        }
        catch (HibernateException e) {
            e.printStackTrace();
        }
        return smsModels;
    }

    @Override
    public List<SMSModel> getRangedSentSMS(Integer start, Integer noOfResult) {
        List smsModels = null;
        try {
            Criteria criteria = this.getHibernateSession().createCriteria((Class)SMSModel.class).add((Criterion)Restrictions.eq((String)"status", (Object)"Sent"));
            criteria.setMaxResults(noOfResult.intValue());
            criteria.setFirstResult(start.intValue());
            smsModels = criteria.list();
        }
        catch (HibernateException e) {
            e.printStackTrace();
        }
        return smsModels;
    }
}

