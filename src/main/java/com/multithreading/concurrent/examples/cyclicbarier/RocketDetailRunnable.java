package com.multithreading.concurrent.examples.cyclicbarier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class RocketDetailRunnable implements Runnable {

    private final RocketDetail rocketDetail;
    private final CyclicBarrier cyclicBarrier;

    public RocketDetailRunnable(RocketDetail rocketDetail, CyclicBarrier cyclicBarrier) {
        this.rocketDetail = rocketDetail;
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        System.out.println("Готовится деталь " + rocketDetail);
        try {
            Thread.sleep(2000);
            System.out.println("Деталь готова и ожидает: " + rocketDetail);
            //каждый поток ожидает до тех пор, пока определенное количество потоков не вызовет await() на этом барьере
            cyclicBarrier.await();// в нашем случает - пока 5 потоков не вызоыет этот метод (5 деталей)
            System.out.println("Деталь использована: " + rocketDetail);
        } catch (InterruptedException | BrokenBarrierException e){
            e.printStackTrace();
        }
    }
}
