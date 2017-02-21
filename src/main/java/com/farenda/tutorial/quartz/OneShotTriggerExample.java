package com.farenda.tutorial.quartz;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

/**
 * Tutorial from  http://farenda.com/quartz/quartz-scheduler-one-shot-trigger/
 */
public class OneShotTriggerExample {

    public static void main(String[] args)
            throws SchedulerException, InterruptedException {
        SchedulerFactory factory = new StdSchedulerFactory();
        Scheduler scheduler = factory.getScheduler();

        scheduler.start();

        JobDetail jobDetail = newJob(PingJob.class)
                .withIdentity("job name", "job group")
                .build();

        Trigger trigger = newTrigger()
                .withIdentity("trigger name", "trigger group")
                .startNow()
                .build();

        System.out.println("Scheduling the job:");
        scheduler.scheduleJob(jobDetail, trigger);
        Thread.sleep(1000);
        System.out.println("Shutting down the scheduler...");

        scheduler.shutdown(true);
    }
}