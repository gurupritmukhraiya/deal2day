package com.d2d.db.exception;

import java.io.Serializable;

public class DBServiceIssueHandler
implements IssueHandlerIntf,
Serializable {
    private static final long serialVersionUID = 1;

    @Override
    public boolean fix(Exception ex) {
        if (ex instanceof HibernateIssue) {
            System.out.println("----------Exception Coming in Hibernate Layer--------");
            return false;
        }
        if (ex instanceof UnknownIssue) {
            System.out.println("---------Cannot Fix System Exception--------- ");
            return false;
        }
        return true;
    }

    @Override
    public boolean verify(Exception ex) {
        if (ex instanceof HibernateIssue) {
            return this.testHibernate();
        }
        return true;
    }

    private boolean testHibernate() {
        return false;
    }

    @Override
    public Exception wrapForNextLayer(Exception ex) {
        return null;
    }
}

