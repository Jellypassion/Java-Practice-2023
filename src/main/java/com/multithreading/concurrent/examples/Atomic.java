package com.multithreading.concurrent.examples;

import java.util.concurrent.atomic.AtomicInteger;

public class Atomic {
    public static void main(String[] args) {
        var atomicInteger = new AtomicInteger(5);// like an Integer it is a shell over an int, but it's thread-safe
        atomicInteger.incrementAndGet();
        System.out.println(atomicInteger);
    }
}
