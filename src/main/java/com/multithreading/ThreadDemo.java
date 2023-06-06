package com.multithreading;

public class ThreadDemo {
    public static void main(String[] args) {
        var simpleThread = new SimpleThread();

        // When implementing threads via Runnable interface the thread cannot start without class Thread
        // So we need to create a Thread instance for it
        // v1
        Thread runnableThread = new Thread(new SimpleRunnable());

        // v2
        // one of its constructors accepts Runnable func interface
        var lambdsThread = new Thread(() ->
                System.out.println("Hello from lambda " + Thread.currentThread().getName()));

        // To make this thread start separately method start() must be called
        simpleThread.start();
        runnableThread.start();
        lambdsThread.start();
        try {
            simpleThread.join(); // This method tells the thread to execute until it's terminated.
            runnableThread.join();
            lambdsThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        simpleThread.interrupt();// interrupts the thread

        // if some threads are defined with join() method, the next lines won't be executed until those threads finish execution
        // in other words the main thread waits until all other threads are terminated
        System.out.println(Thread.currentThread().getName());// main thread

    }
}
