package com.multithreading.queue;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CashboxRunner {
    public static void main(String[] args) throws InterruptedException {
//        Queue<Cashbox> cashboxes = new ArrayDeque<>(List.of(new Cashbox(), new Cashbox()));
        //Changing Queue into BlockingQueue
        BlockingQueue<Cashbox> cashboxes =
                new ArrayBlockingQueue<>(2, true, List.of(new Cashbox(), new Cashbox()));// params are: capacity, fair (take items in order or not), collection object

        List<Thread> threads = Stream.of(
                        new BuyerThread(cashboxes),
                        new BuyerThread(cashboxes),
                        new BuyerThread(cashboxes),
                        new BuyerThread(cashboxes),
                        new BuyerThread(cashboxes),
                        new BuyerThread(cashboxes),
                        new BuyerThread(cashboxes),
                        new BuyerThread(cashboxes),
                        new BuyerThread(cashboxes)
                )
                .map(Thread::new)
                .peek(Thread::start)
                .collect(Collectors.toList());
        // we need to call join on each thread separately from lambda in case to handle the exception
        for (Thread thread : threads) {
            thread.join();
        }

    }
}
