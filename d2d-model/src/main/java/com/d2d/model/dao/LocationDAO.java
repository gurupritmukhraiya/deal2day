package com.d2d.model.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;

import com.d2d.db.exception.DBServiceException;
import com.d2d.db.exception.DBServiceIssueHandler;
import com.d2d.db.exception.HibernateInteralExceptionSupDBService;
import com.d2d.db.exception.IssueHandlerIntf;
import com.d2d.db.exception.UnknownExceptionSupDBService;
import com.d2d.model.beans.LocationModel;
import com.d2d.model.dao.intf.LocationDAOIntf;

public class LocationDAO extends GenricDAOAbs implements LocationDAOIntf {
    private static final Log log = LogFactory.getLog(LocationDAO.class);
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
    public void create(LocationModel locationModel) throws DBServiceException {
        super.create(locationModel, this.getCurrentSession());
    }

    @Override
    public LocationModel getLocationByIdx(long idx) throws DBServiceException {
        log.debug((Object)("finding instance with id: " + idx));
        try {
            String queryStr = "from LocationModel location where location.idx = '" + idx + "'";
            Query query = this.getCurrentSession().createQuery(queryStr);
            LocationModel locationModel = (LocationModel)query.uniqueResult();
            return locationModel;
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
    public void delete(long idx) throws DBServiceException {
        String hql = "delete LocationModel location where location.idx=" + idx;
        super.executeQuery(hql, this.getCurrentSession());
    }
}

