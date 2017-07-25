package com.d2d.db.exception;

import com.d2d.db.exception.DBServiceException;
import com.d2d.db.exception.HibernateIssue;
import com.d2d.db.exception.IssueHandlerIntf;

public class HibernateInteralExceptionSupDBService
extends DBServiceException
implements HibernateIssue {
    private static final long serialVersionUID = 3174958799566326637L;
    private IssueHandlerIntf issueHandler;

    public HibernateInteralExceptionSupDBService(Exception ex, IssueHandlerIntf issueHander) {
        super(ex);
        this.issueHandler = issueHander;
    }

    @Override
    public void reportHibernateIssue() {
        this.issueHandler.fix(this);
    }

    @Override
    public void handle() {
        this.reportHibernateIssue();
    }
}

