package com.multithreading.concurrent.examples.latch;

import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class LatchDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(RocketDetail.values().length);
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        // один из трех потоков занимает сама ракета
        executorService.submit(new Rocket(countDownLatch));
        // В оставшихся двух готовятся детали
        Arrays.stream(RocketDetail.values())
                .map(detail -> new RocketDetailRunnable(detail, countDownLatch))
                .forEach(executorService::submit);
        // Не забывать завершать пул потоков
        executorService.shutdown();// Сигнал к завершению
        executorService.awaitTermination(1L, TimeUnit.MINUTES);// Ожидание пока executorService не завершит работу
    }
}
