package com.d2d.db.exception;

public class LoadProperyFileException
extends RuntimeException {
    private static final long serialVersionUID = -1548430439288136485L;
    String message;
    private Exception exception;
    public static String propertyFileSyntaxError = "Unable to read property file is not well written";

    public LoadProperyFileException(String msg, Exception e) {
        this.message = msg;
        this.exception = e;
    }

    public void addCause(String cause) {
        this.message = String.valueOf(this.message) + " " + cause;
    }

    public void addEffect(String effect) {
        this.message = String.valueOf(this.message) + " \nresulted into " + effect;
    }

    @Override
    public String getMessage() {
        return String.valueOf(this.message) + (this.exception != null ? this.exception.getMessage() : "");
    }

    @Override
    public String toString() {
        return this.getMessage();
    }
}

