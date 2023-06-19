package com.multithreading.pool;

import java.util.concurrent.*;

public class ThreadPoolDemo {
    public static void main(String[] args) {
        // Executors is a utility class for thread pools (like classes Arrays, Objects, Collections etc.)
//        Executors.newSingleThreadExecutor();// creates a thread pool which consists of a single thread
//        Executors.newFixedThreadPool(5);// creates a thread pool of 5 threads
//        Executors.newCachedThreadPool();// endless thread pool which creates as many threads as we give tasks
//        Executors.newScheduledThreadPool(3);// Creates a thread pool that can schedule commands to run after a given delay, or to execute periodically
//        Executors.newWorkStealingPool();// Creates a work-stealing thread pool using the number of available processors as its target parallelism level.
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(4);
//        scheduledThreadPool.schedule(() -> System.out.println("OK! (with delay)"), 3L, TimeUnit.SECONDS ); // Executes the command with a delay of 3 seconds
//        // shutdown() используется в случае если threadPool - это локальная переменная. В реальных проектах threadPool создается ка поля класса
//        scheduledThreadPool.shutdown();
//        scheduledThreadPool.awaitTermination(1L, TimeUnit.HOURS);

        scheduledThreadPool.scheduleAtFixedRate(() -> System.out.println("OK!"), 3L, 2L, TimeUnit.SECONDS); // Executes multiple times every 2 sec and with initial delay of 3 sec
// добавить все в ноушн!
    }

    private static void test() throws InterruptedException, ExecutionException {
        ExecutorService threadpool = Executors.newFixedThreadPool(5);
        // Future - это объект с результатом выполнения задачи, который будет в будущем
        Future<Integer> future = threadpool.submit(() -> {
            Thread.sleep(2000);
            System.out.println("It's callable");
            return 1;
        });
        System.out.println("Result: " + future.get());
        threadpool.shutdown(); // A way to close threadpool
        threadpool.awaitTermination(1L, TimeUnit.HOURS); // indicating for how max long we should wait for termination
        System.out.println("main end");
    }
}
