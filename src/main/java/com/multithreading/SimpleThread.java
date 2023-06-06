package com.multithreading;

public class SimpleThread extends Thread {
    @Override
    public void run() {
        System.out.println("Hello " + currentThread().getName());
    }
}
