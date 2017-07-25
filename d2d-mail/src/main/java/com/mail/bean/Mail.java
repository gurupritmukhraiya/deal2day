/*
 * Decompiled with CFR 0_101.
 */
package com.mail.bean;

import java.io.File;
import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Mail
implements Serializable {
    private static final long serialVersionUID = -5594191350862184837L;
    private Long mailId;
    private String from;
    private String to;
    private String subject;
    private Date createdDate;
    private String status;
    private byte[] body;
    private List<File> attachments = new LinkedList<File>();

    public Mail() {
    }

    public Mail(String from, String to, String subject, byte[] body, List<File> attachments) {
        this.from = from;
        this.to = to;
        this.subject = subject;
        this.body = body;
        this.attachments = attachments;
    }

    public Long getMailId() {
        return this.mailId;
    }

    public void setMailId(Long mailId) {
        this.mailId = mailId;
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

    public String getSubject() {
        return this.subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public byte[] getBody() {
        return this.body;
    }

    public void setBody(byte[] body) {
        this.body = body;
    }

    public List<File> getAttachments() {
        return this.attachments;
    }

    public void setAttachments(List<File> attachments) {
        this.attachments = attachments;
    }

    public void addAttachment(File attachment) {
        this.attachments.add(attachment);
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

