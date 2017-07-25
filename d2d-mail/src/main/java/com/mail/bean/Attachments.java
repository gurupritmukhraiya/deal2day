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
package com.mail.bean;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="_attachments")
public class Attachments
implements Serializable {
    private static final long serialVersionUID = 867277445540737512L;
    private Long attachmentId;
    private String attachmentName;
    private byte[] attachmentContent;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="ATTACHMENT_ID", unique=true, nullable=false)
    public Long getAttachmentId() {
        return this.attachmentId;
    }

    public void setAttachmentId(Long attachmentId) {
        this.attachmentId = attachmentId;
    }

    @Column(name="ATTACHMENT_NAME", nullable=false)
    public String getAttachmentName() {
        return this.attachmentName;
    }

    public void setAttachmentName(String attachmentName) {
        this.attachmentName = attachmentName;
    }

    @Column(name="ATTACHMENT_CONTENT", nullable=false, columnDefinition="LONGBLOB")
    public byte[] getAttachmentContent() {
        return this.attachmentContent;
    }

    public void setAttachmentContent(byte[] attachmentContent) {
        this.attachmentContent = attachmentContent;
    }
}

