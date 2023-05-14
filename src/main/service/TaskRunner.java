package main.service;

import java.util.function.Function;

public class TaskRunner implements Runnable {
    private final Function<Void, Void> task;

    public TaskRunner(Function<Void, Void> task) {
        this.task = task;
    }


    @Override
    public void run() {
        // Call the task function
        task.apply(null);
    }
}


