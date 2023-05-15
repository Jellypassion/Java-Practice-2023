package com.collections;

import com.generics.List;

public class ListExample {
    public static void main(String[] args) {
        List<String> list = new List<>(10);
        list.add("String1");
        list.add("String2");
        list.add("String3");
        list.add("String4");

        list.iterator().forEachRemaining(System.out::println);

    }
}
