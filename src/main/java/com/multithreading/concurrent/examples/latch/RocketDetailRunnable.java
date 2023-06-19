package com.multithreading.concurrent.examples.latch;

import java.util.concurrent.CountDownLatch;

public class RocketDetailRunnable implements Runnable {

    private final RocketDetail rocketDetail;
    private final CountDownLatch countDownLatch;

    public RocketDetailRunnable(RocketDetail rocketDetail, CountDownLatch countDownLatch) {
        this.rocketDetail = rocketDetail;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        System.out.println("Готовится деталь " + rocketDetail);
        try {
            Thread.sleep(2000);
            System.out.println("Деталь готова: " + rocketDetail);
            countDownLatch.countDown();// Decrements the count of the latch, releasing all waiting threads if the count reaches zero
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
