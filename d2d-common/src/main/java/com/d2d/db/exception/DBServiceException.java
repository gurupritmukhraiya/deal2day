package com.d2d.db.exception;

public class DBServiceException
extends Exception {
    private static final long serialVersionUID = 3224537659562930177L;

    public DBServiceException(Exception e) {
        super(e);
    }
}

