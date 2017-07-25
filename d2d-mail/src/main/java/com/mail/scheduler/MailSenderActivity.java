/*
 * Decompiled with CFR 0_101.
 * 
 * Could not load the following classes:
 *  org.quartz.Job
 *  org.quartz.JobExecutionContext
 *  org.quartz.JobExecutionException
 */
package com.mail.scheduler;

import com.core.mail.sender.service.MailService;
import com.mail.util.MailProperties;
import java.io.PrintStream;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class MailSenderActivity
implements Job {
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("Mail Sender Scheduler Running ...");
        int numberOfMails = Integer.parseInt(MailProperties.getProperty("schduler.number.of.mails"));
        MailService.getInstanse().sendNumberOfActiveMailsFromDB(numberOfMails);
    }
}

