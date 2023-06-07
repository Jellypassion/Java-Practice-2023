package com.multithreading.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListDemo {
    public static void main(String[] args) {
        List<Integer> integers = Collections.synchronizedList(new ArrayList<>());

        var listThread1 = new ListThread(integers);
        var listThread2 = new ListThread(integers);
        var listThread3 = new ListThread(integers);
        var listThread4 = new ListThread(integers);
        var listThread5 = new ListThread(integers);
        var listThread6 = new ListThread(integers);
        var listThread7 = new ListThread(integers);

        listThread1.start();
        listThread2.start();
        listThread3.start();
        listThread4.start();
        listThread5.start();
        listThread6.start();
        listThread7.start();
        try {
            listThread1.join();
            listThread2.join();
            listThread3.join();
            listThread4.join();
            listThread5.join();
            listThread6.join();
            listThread7.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(integers);
    }
}
