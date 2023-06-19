package com.multithreading.pool;

import java.util.Optional;
import java.util.Queue;

public class PoolThread extends Thread {
    private final Queue<Runnable> tasks; // a queue of tasks to be executed

    public PoolThread(Queue<Runnable> tasks) {
        this.tasks = tasks;
    }

    @Override
    public void run() {
        while (true) {
            Optional<Runnable> task = Optional.empty();
            synchronized (tasks) {
                if (!tasks.isEmpty()) {
                    task = Optional.of(tasks.remove());
                }
                task.ifPresent(Runnable::run);
            }
        }
    }
}
