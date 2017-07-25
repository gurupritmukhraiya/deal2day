/*
 * Decompiled with CFR 0_101.
 * 
 * Could not load the following classes:
 *  org.quartz.JobBuilder
 *  org.quartz.JobDetail
 *  org.quartz.ScheduleBuilder
 *  org.quartz.Scheduler
 *  org.quartz.SimpleScheduleBuilder
 *  org.quartz.Trigger
 *  org.quartz.TriggerBuilder
 *  org.quartz.impl.StdSchedulerFactory
 */
package com.mail.scheduler;

import com.mail.scheduler.MailSenderActivity;
import com.mail.util.MailProperties;
import java.util.Date;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.ScheduleBuilder;
import org.quartz.Scheduler;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class MailSenderScheduler {
    public MailSenderScheduler() {
        try {
            this.start();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void start() throws Exception {
        Scheduler scheduler = new StdSchedulerFactory().getScheduler();
        scheduler.start();
        if (MailProperties.getProperty("schduler.enable") != null && Boolean.parseBoolean(MailProperties.getProperty("schduler.enable"))) {
            int mailSenderIntervalSeconds = Integer.parseInt(MailProperties.getProperty("schduler.interval.seconds"));
            JobDetail mailSenderJob = JobBuilder.newJob((Class)MailSenderActivity.class).withIdentity("MailSenderJob", "MailSenderScheduler").build();
            Trigger mailSenderJobTrigger = TriggerBuilder.newTrigger().withIdentity("MailSenderJob", "MailSenderScheduler").withSchedule((ScheduleBuilder)SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(mailSenderIntervalSeconds).repeatForever()).build();
            scheduler.scheduleJob(mailSenderJob, mailSenderJobTrigger);
        }
    }

    public static void main(String[] args) {
        new com.mail.scheduler.MailSenderScheduler();
    }
}

