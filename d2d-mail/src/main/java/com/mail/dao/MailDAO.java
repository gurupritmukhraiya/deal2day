package com.mail.dao;

import com.mail.bean.MailModel;
import com.mail.dao.intf.MailDAOIntf;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class MailDAO
extends HibernateDaoSupport
implements MailDAOIntf {
    private Session session;

    public MailDAO() {
    }

    public MailDAO(Session session) {
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
    public void create(MailModel mailModel) {
        try {
            this.getHibernateSession().saveOrUpdate((Object)mailModel);
        }
        catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public MailModel getMailById(Long id) {
        MailModel mailModel = null;
        try {
            mailModel = (MailModel)this.getHibernateSession().load((Class)MailModel.class, (Serializable)id);
        }
        catch (HibernateException e) {
            e.printStackTrace();
        }
        return mailModel;
    }

    @Override
    public List<MailModel> getMails() {
        List mails = null;
        try {
            mails = this.getHibernateSession().createCriteria((Class)MailModel.class).list();
        }
        catch (HibernateException e) {
            e.printStackTrace();
        }
        return mails;
    }

    @Override
    public void update(MailModel mailModel) {
        try {
            this.getHibernateSession().saveOrUpdate((Object)mailModel);
        }
        catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(MailModel mailModel) {
        try {
            this.getHibernateSession().delete((Object)mailModel);
        }
        catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<MailModel> getActiveMails() {
        List mails = null;
        try {
            Criteria criteria = this.getHibernateSession().createCriteria((Class)MailModel.class).add((Criterion)Restrictions.eq((String)"status", (Object)"A"));
            mails = criteria.list();
        }
        catch (HibernateException e) {
            e.printStackTrace();
        }
        return mails;
    }

    @Override
    public List<MailModel> getNumberOfActiveMails(Integer number) {
        List mails = null;
        try {
            Criteria criteria = this.getHibernateSession().createCriteria((Class)MailModel.class).add((Criterion)Restrictions.eq((String)"status", (Object)"A"));
            criteria.setMaxResults(number.intValue());
            mails = criteria.list();
        }
        catch (HibernateException e) {
            e.printStackTrace();
        }
        return mails;
    }

    @Override
    public List<MailModel> getRangedActiveMails(Integer start, Integer noOfResult) {
        List mails = null;
        try {
            Criteria criteria = this.getHibernateSession().createCriteria((Class)MailModel.class).add((Criterion)Restrictions.eq((String)"status", (Object)"A"));
            criteria.setMaxResults(noOfResult.intValue());
            criteria.setFirstResult(start.intValue());
            mails = criteria.list();
        }
        catch (HibernateException e) {
            e.printStackTrace();
        }
        return mails;
    }

    @Override
    public List<MailModel> getSentMails() {
        List mails = null;
        try {
            Criteria criteria = this.getHibernateSession().createCriteria((Class)MailModel.class).add((Criterion)Restrictions.eq((String)"status", (Object)"Sent"));
            mails = criteria.list();
        }
        catch (HibernateException e) {
            e.printStackTrace();
        }
        return mails;
    }

    @Override
    public List<MailModel> getNumberOfSentMails(Integer number) {
        List mails = null;
        try {
            Criteria criteria = this.getHibernateSession().createCriteria((Class)MailModel.class).add((Criterion)Restrictions.eq((String)"status", (Object)"Sent"));
            criteria.setMaxResults(number.intValue());
            mails = criteria.list();
        }
        catch (HibernateException e) {
            e.printStackTrace();
        }
        return mails;
    }

    @Override
    public List<MailModel> getRangedSentMails(Integer start, Integer noOfResult) {
        List mails = null;
        try {
            Criteria criteria = this.getHibernateSession().createCriteria((Class)MailModel.class).add((Criterion)Restrictions.eq((String)"status", (Object)"Sent"));
            criteria.setMaxResults(noOfResult.intValue());
            criteria.setFirstResult(start.intValue());
            mails = criteria.list();
        }
        catch (HibernateException e) {
            e.printStackTrace();
        }
        return mails;
    }
}

