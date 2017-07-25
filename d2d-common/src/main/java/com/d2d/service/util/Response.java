package com.d2d.service.util;

import java.io.Serializable;

public class Response
implements Serializable {
    private static final long serialVersionUID = -5561054302091239978L;
    public static final String SUCCESS = "success";
    public static final String FAIL = "fail";
    private String status;
    private String massage;

    public Response(String status, String massage) {
        this.status = status;
        this.massage = massage;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMassage() {
        return this.massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }
}

