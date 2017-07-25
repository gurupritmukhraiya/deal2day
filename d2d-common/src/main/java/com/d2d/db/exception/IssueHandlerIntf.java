package com.d2d.db.exception;

public interface IssueHandlerIntf {
    public boolean verify(Exception var1);

    public boolean fix(Exception var1);

    public Exception wrapForNextLayer(Exception var1);
}

