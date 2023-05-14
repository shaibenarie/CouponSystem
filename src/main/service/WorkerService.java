package main.service;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class WorkerService {
    private ScheduledExecutorService scheduler;

    public WorkerService(Runnable task, int intervalInHours) {
        scheduler = Executors.newSingleThreadScheduledExecutor();
        scheduler.scheduleAtFixedRate(task, 0, intervalInHours, TimeUnit.HOURS);
    }

    public void stop() {
        scheduler.shutdown();
    }
}

