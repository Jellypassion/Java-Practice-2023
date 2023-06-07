package com.multithreading.counter;

/**
 * 1. Создать класс Counter с одним полем:
 * private int count;
 * <p>
 * Добавить методы:
 * - getCount() - для получение поля count
 * - increment() - для увеличения значения поля на единицу
 * - decrement() - для уменьшения значения поля на единицу
 */
public class Counter {

    public static String description;
    private int count;

    // for static methods
    // v1
//    public synchronized static void init() {
//        if (description == null) {
//            description = "Test description";
//        }
//    }

    // v2
    public static void init() {
        synchronized (Counter.class){
            if (description == null) {
                description = "Test description";
            }
        }
    }

    // v1
//    public synchronized void increment() {
//        count++;
//    }

    // v2
    public void increment() {
        synchronized (this) {
            count++;
        }
    }

    public void decrement() {
        count--;
    }

    public int getCount() {
        return count;
    }
}
