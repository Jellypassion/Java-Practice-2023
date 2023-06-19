package com.multithreading.concurrent.examples.latch;

import java.util.concurrent.CountDownLatch;

public class Rocket implements Runnable {

    private final CountDownLatch countDownLatch;

    public Rocket(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        System.out.println("Ракета готовится к запуску...");
        try {
            // Causes the current thread to wait until the latch has counted down to zero
            countDownLatch.await();// ожидаем до тех пор, пока основные детали не будут сделаны
            System.out.println("Пуск!!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
