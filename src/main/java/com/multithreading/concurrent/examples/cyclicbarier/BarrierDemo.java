package com.multithreading.concurrent.examples.cyclicbarier;

import java.util.Arrays;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BarrierDemo {
    public static void main(String[] args) throws InterruptedException {
        // Creates a new CyclicBarrier that will trip when the given number of parties (threads) are waiting upon it, and then executes the given barrier action
        CyclicBarrier barrier = new CyclicBarrier(RocketDetail.values().length, () -> System.out.println("Пуск!"));

        ExecutorService threadPool = Executors.newCachedThreadPool();
        // Для пуска ракеты не добавляем эту задачу в threadPool, поскольку выполнение этого действия задвется в конструкторе барьера
        Arrays.stream(RocketDetail.values())
                .map(rocketDetail -> new RocketDetailRunnable(rocketDetail, barrier))
                .forEach(threadPool::submit);// equals to threadPool.submit(it)
        threadPool.shutdown();
        threadPool.awaitTermination(1L, TimeUnit.MINUTES);
    }
}
