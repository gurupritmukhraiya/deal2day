package com.d2d.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;

import com.d2d.db.exception.DBServiceException;
import com.d2d.db.exception.DBServiceIssueHandler;
import com.d2d.db.exception.HibernateInteralExceptionSupDBService;
import com.d2d.db.exception.IssueHandlerIntf;
import com.d2d.db.exception.UnknownExceptionSupDBService;
import com.d2d.model.beans.MerchantLogin;
import com.d2d.model.beans.MerchantNameModel;
import com.d2d.model.beans.MerchantProfile;
import com.d2d.model.dao.intf.MerchantDAOIntf;

public class MerchantDAO extends GenricDAOAbs implements MerchantDAOIntf {
	
    private static final Log log = LogFactory.getLog(MerchantDAO.class);
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
    public void create(MerchantLogin providerLogin) throws DBServiceException {
        super.create(providerLogin, this.getCurrentSession());
    }

    @Override
    public MerchantLogin getMerchantById(long idx, boolean isFetchLocation, boolean isFetchOffer) throws DBServiceException {
        log.debug((Object)("finding instance with id: " + idx));
        try {
            String queryStr = "from MerchantLogin merchantLogin where merchantLogin.idx = '" + idx + "'";
            Query query = this.getCurrentSession().createQuery(queryStr);
            MerchantLogin merchantLogin = (MerchantLogin)query.uniqueResult();
            if (isFetchLocation) {
                Hibernate.initialize(merchantLogin.getLocation());
            }
            if (isFetchOffer) {
                Hibernate.initialize(merchantLogin.getOffers());
            }
            return merchantLogin;
        }
        catch (HibernateException he) {
            log.debug((Object)"Find by User id failed");
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
    public void update(MerchantLogin merchantLogin) throws DBServiceException {
        super.update(merchantLogin, this.getCurrentSession());
    }

    @Override
    public MerchantLogin getMerchantByLoginId(String loginId, boolean isFetchLocation, boolean isFetchOffer) throws DBServiceException {
        log.debug((Object)("finding ProviderLogin instance with id: " + loginId));
        try {
            String queryStr = "from MerchantLogin merchantLogin where merchantLogin.merchantId = '" + loginId + "'";
            Query query = this.getCurrentSession().createQuery(queryStr);
            MerchantLogin merchantLogin = (MerchantLogin)query.uniqueResult();
            if (isFetchLocation) {
                Hibernate.initialize(merchantLogin.getLocation());
            }
            if (isFetchOffer) {
                Hibernate.initialize(merchantLogin.getOffers());
            }
            return merchantLogin;
        }
        catch (HibernateException he) {
            log.debug((Object)"Find by User id failed");
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
    
	@SuppressWarnings("unchecked")
	@Override
	public List<MerchantLogin> getAllMerchants() throws DBServiceException {
		log.debug((Object)"finding all merchants");
        List<MerchantLogin> merchants = new ArrayList<MerchantLogin>();
        try {
            Criteria criteria = this.getCurrentSession().createCriteria(MerchantLogin.class);
            merchants = (ArrayList<MerchantLogin>)criteria.list();
            return merchants;
        }
        catch (HibernateException he) {
            log.debug((Object)"get all merchant failed");
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
    public void createMerchantName(MerchantNameModel merchantNameModel) throws DBServiceException {
         super.create(merchantNameModel, this.getCurrentSession());
       
    }
   
	@Override
    public List<MerchantNameModel> getAllMerchantName() throws DBServiceException {
        List<MerchantNameModel> merchantLists = new ArrayList<MerchantNameModel>();
        try {
            long var1 = -1;
            String queryStr = "from MerchantNameModel merchantNameModel"; //where merchantNameModel.merchantId = '"+ var1 +"'";
            Query query = this.getCurrentSession().createQuery(queryStr);
            List<MerchantNameModel> merchantName = query.list();
            return merchantName;
        }
        catch (HibernateException he) {
            log.debug((Object)"Find by User id failed");
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
    //TODO get update merchant id
   
    public void updateMerchantName(long id, long merchantId) throws DBServiceException {
        try{
           
            String queryStr = "update MerchantNameModel merchantName set merchantName.merchantId='"+merchantId+"' where merchantName.idx='"+ id +"'";
            Query query = this.getCurrentSession().createQuery(queryStr);
            query.executeUpdate();
           
        } catch (HibernateException he) {
            log.debug((Object)"Find by category parent id failed");
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
   
    public MerchantNameModel getMerchantByName(String name) throws DBServiceException {
        try{
           String queryStr = "from MerchantNameModel merchantName where merchantName.pname = '" + name + "'";
           Query query = this.getCurrentSession().createQuery(queryStr);
           MerchantNameModel merchantName = (MerchantNameModel)query.uniqueResult();
           return merchantName;
            } catch (HibernateException he) {
                log.debug((Object)"Find by category parent id failed");
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
    public boolean isMerchantNameExist(String merchantName) throws DBServiceException {
        try{
        	Query query = getCurrentSession().createQuery("select count(*) from MerchantProfile profile where profile.merchantName=:merchantName");
        	query.setString("merchantName", merchantName);
        	Long count = (Long)query.uniqueResult();
        	if(count != 0){
        		return true;
        	}
        	return false;
        } catch (HibernateException he) {
        	log.debug((Object)"Find by category parent id failed");
        	HibernateInteralExceptionSupDBService hibernateInteralExceptionSupDBService = new HibernateInteralExceptionSupDBService((Exception)he, (IssueHandlerIntf)new DBServiceIssueHandler());
        	hibernateInteralExceptionSupDBService.handle();
        	hibernateInteralExceptionSupDBService.printStackTrace();
        	throw hibernateInteralExceptionSupDBService;
        }catch (Exception ex) {
        	UnknownExceptionSupDBService unknownIssue = new UnknownExceptionSupDBService(ex, (IssueHandlerIntf)new DBServiceIssueHandler());
        	unknownIssue.handle();
        	unknownIssue.printStackTrace();
        	throw unknownIssue;
        }
    }
    
    @Override
    public List<MerchantProfile> getMerchants() throws DBServiceException {
    	    return (ArrayList<MerchantProfile>)super.findAll(MerchantProfile.class, this.getCurrentSession());
    }
}

