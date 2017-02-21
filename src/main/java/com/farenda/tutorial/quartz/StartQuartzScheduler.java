package com.farenda.tutorial.quartz;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;

public class StartQuartzScheduler {

    public static void main(String[] args)
            throws SchedulerException {
        SchedulerFactory factory = new StdSchedulerFactory();
        Scheduler scheduler = factory.getScheduler();

        scheduler.start();
        System.out.println("Scheduler started? "
                + scheduler.isStarted());

        // print some info about the Scheduler
        System.out.println("Scheduler name: "
                + scheduler.getSchedulerName());
        System.out.println("Scheduler instanceId: "
                + scheduler.getSchedulerInstanceId());

        boolean waitForJobsToComplete = true;
        scheduler.shutdown(waitForJobsToComplete);
        System.out.println("Scheduler shutdown? "
                + scheduler.isShutdown());
    }
}