/*
 * Decompiled with CFR 0_101.
 * 
 * Could not load the following classes:
 *  org.quartz.Job
 *  org.quartz.JobExecutionContext
 *  org.quartz.JobExecutionException
 */
package com.sms.scheduler;

import com.core.sms.sender.service.SMSService;
import com.sms.util.SMSProperties;
import java.io.PrintStream;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class SMSSenderActivity
implements Job {
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("SMS Sender Scheduler Running ...");
        int numberOfSMS = Integer.parseInt(SMSProperties.getProperty("schduler.number.of.sms"));
        SMSService.getInstanse().sendNumberOfActiveSMSFromDB(numberOfSMS);
    }
}

