/*
 * Decompiled with CFR 0_101.
 */
package com.mail.util;

import com.mail.bean.Attachments;
import com.mail.bean.Mail;
import com.mail.bean.MailModel;
import com.mail.util.FileUtil;
import java.io.File;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class MailCovertor {
    private static MailCovertor mailUtil;

    private MailCovertor() {
    }

    public static MailCovertor getInstanse() {
        if (mailUtil == null) {
            mailUtil = new MailCovertor();
        }
        return mailUtil;
    }

    public MailModel convertMailToMailModel(Mail mail) {
        MailModel mailModel = null;
        if (mail != null) {
            mailModel = new MailModel();
            HashSet<Attachments> attachmentModels = new HashSet<Attachments>();
            List<File> attachments = mail.getAttachments();
            for (File attachment : attachments) {
                byte[] attachmentContent = FileUtil.getInstanse().convertFileToByteArray(attachment);
                Attachments attachmentModel = new Attachments();
                attachmentModel.setAttachmentName(attachment.getName());
                attachmentModel.setAttachmentContent(attachmentContent);
                attachmentModels.add(attachmentModel);
            }
            mailModel.setAttachments(attachmentModels);
            mailModel.setFrom(mail.getFrom());
            mailModel.setTo(mail.getTo());
            mailModel.setSubject(mail.getSubject());
            mailModel.setBody(mail.getBody());
            mailModel.setStatus(mail.getStatus());
            mailModel.setCreatedDate(mail.getCreatedDate());
        }
        return mailModel;
    }

    public Mail convertMailModelToMail(MailModel mailModel) {
        Mail mail = null;
        if (mailModel != null) {
            mail = new Mail();
            Set<Attachments> attachmentModels = mailModel.getAttachments();
            LinkedList<File> attachments = new LinkedList<File>();
            for (Attachments attachmentModel : attachmentModels) {
                File file = FileUtil.getInstanse().convertByteArrayToFile(attachmentModel.getAttachmentContent(), attachmentModel.getAttachmentName());
                attachments.add(file);
            }
            mail.setAttachments(attachments);
            mail.setFrom(mailModel.getFrom());
            mail.setTo(mailModel.getTo());
            mail.setSubject(mailModel.getSubject());
            mail.setBody(mailModel.getBody());
            mail.setStatus(mailModel.getStatus());
            mail.setCreatedDate(mailModel.getCreatedDate());
            mail.setMailId(mailModel.getMailId());
        }
        return mail;
    }
}

