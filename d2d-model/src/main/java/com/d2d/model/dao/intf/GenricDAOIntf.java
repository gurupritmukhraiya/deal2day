package com.d2d.model.dao.intf;

import java.util.Map;

import org.hibernate.Session;

import com.d2d.db.exception.DBServiceException;

public interface GenricDAOIntf {
    public void create(Object var1, Session var2) throws DBServiceException;

    @SuppressWarnings("rawtypes")
	public Object findById(Class var1, Long var2, Session var3) throws DBServiceException;

    @SuppressWarnings("rawtypes")
	public Object findAll(Class var1, Session var2) throws DBServiceException;

    @SuppressWarnings("rawtypes")
	public void update(Class var1, Map<String, String> var2, String var3, long var4, Session var6) throws DBServiceException;

    public void delete(Object var1, Session var2) throws DBServiceException;

    public void executeQuery(String var1, Session var2) throws DBServiceException;

    public void update(Object var1, Session var2) throws DBServiceException;
}

