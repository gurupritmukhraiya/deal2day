package com.d2d.db.exception;

import com.d2d.db.exception.DBServiceException;
import com.d2d.db.exception.IssueHandlerIntf;
import com.d2d.db.exception.UnknownIssue;

public class UnknownExceptionSupDBService
extends DBServiceException
implements UnknownIssue {
    private static final long serialVersionUID = 1;
    private IssueHandlerIntf issueHandlerIntf;

    public UnknownExceptionSupDBService(Exception exception, IssueHandlerIntf issueHandlerIntf) {
        super(exception);
        this.issueHandlerIntf = issueHandlerIntf;
    }

    @Override
    public void reportUnknownIssue() {
        this.issueHandlerIntf.fix(this);
    }

    @Override
    public void handle() {
        this.reportUnknownIssue();
    }
}

