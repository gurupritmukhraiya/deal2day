package com.d2d.model.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.d2d.db.exception.DBServiceException;
import com.d2d.db.exception.DBServiceIssueHandler;
import com.d2d.db.exception.HibernateInteralExceptionSupDBService;
import com.d2d.db.exception.IssueHandlerIntf;
import com.d2d.db.exception.UnknownExceptionSupDBService;
import com.d2d.model.dao.intf.GenricDAOIntf;

public abstract class GenricDAOAbs
implements GenricDAOIntf {
    private static final Log log = LogFactory.getLog(GenricDAOAbs.class);

    @Override
    public void create(Object object, Session session) throws DBServiceException {
        try {
            session.saveOrUpdate(object);
            log.debug((Object)"save successful");
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

    @SuppressWarnings("rawtypes")
	@Override
    public Object findById(Class clazz, Long id, Session session) throws DBServiceException {
        log.debug((Object)("finding OfferModel instance with id: " + id));
        try {
            Object obj = session.load(clazz, (Serializable)id);
            return obj;
        }
        catch (HibernateException he) {
            log.debug((Object)"Find by id failed");
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

    @SuppressWarnings("rawtypes")
	@Override
    public Object findAll(Class clazz, Session session) throws DBServiceException {
        log.debug((Object)("finding all entries from " + clazz.getName()));
        try {
            List object = session.createCriteria(clazz).list();
            return object;
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

    /*
     * (non-Javadoc)
     * @see com.d2d.model.dao.intf.GenricDAOIntf#update(java.lang.Class, java.util.Map, java.lang.String, long, org.hibernate.Session)
     * 
     * added single coats with columnValueMap.get(columnName).
     */
    
    @SuppressWarnings("rawtypes")
	@Override
    public void update(Class clazz, Map<String, String> columnValueMap, String idColumnName, long id, Session session) throws DBServiceException {
        StringBuilder hql = new StringBuilder("UPDATE " + clazz.getName() + " set ");
        for (String columnName : columnValueMap.keySet()) {
            hql.append(String.valueOf(columnName) + "=" + "'"+columnValueMap.get(columnName)+"'" + ", ");
        }
        hql.replace(hql.lastIndexOf(","), hql.lastIndexOf(",") + 1, "");
        hql.append("where " + idColumnName + "=" + id);
        this.executeQuery(hql.toString(), session);
    }

    @Override
    public void update(Object object, Session session) throws DBServiceException {
        try {
            session.saveOrUpdate(object);
            log.debug((Object)"updated successfully");
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

    @Override
    public void delete(Object object, Session session) throws DBServiceException {
        try {
            session.delete(object);
            log.debug((Object)"deleted successful");
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

    @Override
    public void executeQuery(String queryString, Session session) throws DBServiceException {
        try {
            Query query = session.createQuery(queryString);
            int result = query.executeUpdate();
            log.debug((Object)("updated no of rows " + result));
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

