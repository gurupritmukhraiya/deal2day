/*
 * Decompiled with CFR 0_101.
 * 
 * Could not load the following classes:
 *  javax.persistence.Column
 *  javax.persistence.Entity
 *  javax.persistence.FetchType
 *  javax.persistence.GeneratedValue
 *  javax.persistence.GenerationType
 *  javax.persistence.Id
 *  javax.persistence.OneToMany
 *  javax.persistence.Table
 *  org.hibernate.annotations.Cascade
 *  org.hibernate.annotations.CascadeType
 */
package com.mail.bean;

import com.mail.bean.Attachments;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name="_mail")
public class MailModel
implements Serializable {
    private static final long serialVersionUID = 1896831033667505807L;
    private Long mailId;
    private String from;
    private String to;
    private String subject;
    private Date createdDate;
    private String status;
    private byte[] body;
    private Set<Attachments> attachments = new HashSet<Attachments>(0);

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="MAIL_ID", unique=true, nullable=false)
    public Long getMailId() {
        return this.mailId;
    }

    public void setMailId(Long mailId) {
        this.mailId = mailId;
    }

    @Column(name="FROM_MAIL_ID", nullable=false)
    public String getFrom() {
        return this.from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    @Column(name="TO_MAIL_ID", nullable=false)
    public String getTo() {
        return this.to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    @Column(name="SUBJECT", nullable=false)
    public String getSubject() {
        return this.subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Column(name="MAIL_BODY", nullable=false)
    public byte[] getBody() {
        return this.body;
    }

    public void setBody(byte[] body) {
        this.body = body;
    }

    @OneToMany(fetch=FetchType.EAGER)
    @Cascade(value={CascadeType.ALL})
    public Set<Attachments> getAttachments() {
        return this.attachments;
    }

    public void setAttachments(Set<Attachments> attachments) {
        this.attachments = attachments;
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

