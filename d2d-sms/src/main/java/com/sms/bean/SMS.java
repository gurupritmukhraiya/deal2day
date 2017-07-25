/*
 * Decompiled with CFR 0_101.
 */
package com.sms.bean;

import java.io.Serializable;
import java.util.Date;

public class SMS
implements Serializable {
    private static final long serialVersionUID = 7933475315403926989L;
    private Long smsId;
    private String from;
    private String to;
    private String text;
    private String status;
    private Date createdDate;

    public SMS() {
    }

    public SMS(String from, String to, String text) {
        this.from = from;
        this.to = to;
        this.text = text;
    }

    public Long getSmsId() {
        return this.smsId;
    }

    public void setSmsId(Long smsId) {
        this.smsId = smsId;
    }

    public String getFrom() {
        return this.from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return this.to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreatedDate() {
        return this.createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}

