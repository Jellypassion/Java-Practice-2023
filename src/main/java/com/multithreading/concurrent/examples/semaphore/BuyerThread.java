package com.multithreading.concurrent.examples.semaphore;

import java.util.concurrent.Semaphore;

public class BuyerThread implements Runnable {

    // Semaphore служит чтоб ограничивать доступ к каким-то блокам кода или ресурсам путем вызова соответствующих методов
    private final Semaphore cashboxes;

    public BuyerThread(Semaphore cashboxes) {
        this.cashboxes = cashboxes;
    }

    @Override
    public void run() {
        try {
            // Захват монитора. Если не вышло, поток ждет
            cashboxes.acquire();
            System.out.println(Thread.currentThread().getName() + " обслуживается в какой-то кассе ");
            Thread.sleep(5L);
            System.out.println(Thread.currentThread().getName() + " освобождаю какую-то кассу ");
            // освободить монитор
            cashboxes.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

