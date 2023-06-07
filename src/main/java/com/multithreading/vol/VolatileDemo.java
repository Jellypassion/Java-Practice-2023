package com.multithreading.vol;

public class VolatileDemo {

    private static volatile boolean flag = false;

    public static void main(String[] args) throws InterruptedException {
        var thread1 = new Thread(() -> {
            while (!flag) {
                System.out.println("Still false");
            }
        });
        thread1.start();

        Thread.sleep(5L);

        var thread2 = new Thread(() -> {
            flag = true;
            System.out.println("Flag is set");
        });
        thread2.start();
    }
}
