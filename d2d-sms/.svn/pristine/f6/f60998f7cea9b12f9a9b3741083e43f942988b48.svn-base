/*
 * Decompiled with CFR 0_101.
 * 
 * Could not load the following classes:
 *  javax.persistence.Column
 *  javax.persistence.Entity
 *  javax.persistence.GeneratedValue
 *  javax.persistence.GenerationType
 *  javax.persistence.Id
 *  javax.persistence.Table
 */
package com.sms.bean;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sms", catalog="test")
public class SMSModel
implements Serializable {
    private static final long serialVersionUID = -4876758915827312547L;
    private Long smsId;
    private String from;
    private String to;
    private String text;
    private String status;
    private Date createdDate;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="SMS_ID", unique=true, nullable=false)
    public Long getSmsId() {
        return this.smsId;
    }

    public void setSmsId(Long smsId) {
        this.smsId = smsId;
    }

    @Column(name="FROM_MOB_NO", nullable=false)
    public String getFrom() {
        return this.from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    @Column(name="TO_MOB_NO", nullable=false)
    public String getTo() {
        return this.to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    @Column(name="TEXT", nullable=false)
    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Column(name="STATUS", nullable=false)
    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Column(name="CREATED_DATE", nullable=false)
    public Date getCreatedDate() {
        return this.createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}

