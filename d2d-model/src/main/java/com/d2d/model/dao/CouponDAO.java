package com.d2d.model.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.d2d.db.exception.DBServiceException;
import com.d2d.db.exception.DBServiceIssueHandler;
import com.d2d.db.exception.HibernateInteralExceptionSupDBService;
import com.d2d.db.exception.IssueHandlerIntf;
import com.d2d.db.exception.UnknownExceptionSupDBService;
import com.d2d.model.beans.CouponHistoryModel;
import com.d2d.model.beans.MerchantLogin;
import com.d2d.model.beans.SubscriberModel;
import com.d2d.model.dao.intf.CouponDAOIntf;

public class CouponDAO extends GenricDAOAbs implements CouponDAOIntf {
	 private static final Log log = LogFactory.getLog(CouponDAO.class);
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return this.sessionFactory;
    }
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public org.hibernate.Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }

    @Override
    public void addCouponHistory(CouponHistoryModel couponHistoryModel) throws DBServiceException {
       super.create(couponHistoryModel, getCurrentSession());
    }
 
    @Override
    public SubscriberModel getSubscriber(String contact) throws DBServiceException{
    	log.debug((Object)("finding instance with id: " + contact));
        try {
            String queryStr = "from SubscriberModel subscbrModel where subscbrModel.contactNo = '" + contact + "' OR  subscbrModel.email ='" + contact +"' ";
            Query query = this.getCurrentSession().createQuery(queryStr);
            SubscriberModel subscbrModel = (SubscriberModel)query.uniqueResult();
            return subscbrModel;
        }
        catch (HibernateException he) {
            log.debug((Object)"Find by Contact failed");
            HibernateInteralExceptionSupDBService hibernateInteralExceptionSupDBService = new HibernateInteralExceptionSupDBService((Exception)he, (IssueHandlerIntf)new DBServiceIssueHandler());
            hibernateInteralExceptionSupDBService.handle();
            hibernateInteralExceptionSupDBService.printStackTrace();
            throw hibernateInteralExceptionSupDBService;
        }
        catch (Exception ex) {
            UnknownExceptionSupDBService unknownIssue = new UnknownExceptionSupDBService(ex, (IssueHandlerIntf)new DBServiceIssueHandler());
            unknownIssue.handle();
            unknownIssue.printStackTrace();
            throw unknownIssue;
        }
    }
    
    @Override
    public void createSubscriber(SubscriberModel subsModel) throws DBServiceException {
        super.create(subsModel, this.getCurrentSession());
    }
    
    @Override
    public int unSubscribeNewsletter(String contact) throws DBServiceException {
    	
    	        try {
    	        	String deActivate = "DEACTIVE";    	        	
    	        	String queryStr = "update SubscriberModel subscbrModel set subscbrModel.status='"+deActivate+"' where subscbrModel.contactNo = '" + contact + "' OR  subscbrModel.email ='" + contact +"' ";
    	            Query query = this.getCurrentSession().createQuery(queryStr);
    	            return query.executeUpdate();   	            
    	        }
    	        catch (HibernateException he) {
    	            HibernateInteralExceptionSupDBService hibernateInternalExceptionSupDBService = new HibernateInteralExceptionSupDBService((Exception)he, (IssueHandlerIntf)new DBServiceIssueHandler());
    	            hibernateInternalExceptionSupDBService.handle();
    	            he.printStackTrace();
    	            throw hibernateInternalExceptionSupDBService;
    	            
    	        }
    	        catch (Exception ex) {
    	            UnknownExceptionSupDBService unknownIssue = new UnknownExceptionSupDBService(ex, (IssueHandlerIntf)new DBServiceIssueHandler());
    	            unknownIssue.handle();
    	            ex.printStackTrace();
    	            throw unknownIssue;
    	        }
    	        
    	
    }
    

}

