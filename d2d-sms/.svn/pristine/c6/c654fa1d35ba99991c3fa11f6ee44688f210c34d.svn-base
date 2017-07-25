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
package com.sms.scheduler;

import com.sms.scheduler.SMSSenderActivity;
import com.sms.util.SMSProperties;
import java.util.Date;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.ScheduleBuilder;
import org.quartz.Scheduler;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class SMSSenderScheduler {
    public SMSSenderScheduler() {
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
        if (SMSProperties.getProperty("schduler.enable") != null && Boolean.parseBoolean(SMSProperties.getProperty("schduler.enable"))) {
            int smsSenderIntervalSeconds = Integer.parseInt(SMSProperties.getProperty("schduler.interval.seconds"));
            JobDetail smsSenderJob = JobBuilder.newJob((Class)SMSSenderActivity.class).withIdentity("SMSSenderJob", "SMSSenderScheduler").build();
            Trigger smsSenderJobTrigger = TriggerBuilder.newTrigger().withIdentity("SMSSenderJob", "SMSSenderScheduler").withSchedule((ScheduleBuilder)SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(smsSenderIntervalSeconds).repeatForever()).build();
            scheduler.scheduleJob(smsSenderJob, smsSenderJobTrigger);
        }
    }

    public static void main(String[] args) {
        new com.sms.scheduler.SMSSenderScheduler();
    }
}

