package com.generics;

public class ListRunner {
    public static void main(String[] args) {
        List<String> list = new List<>(3);
        list.add("String1");
        list.add("String2");
        list.add("String3");
        list.add("String4");

        String element = list.get(2);
        System.out.println(element);
        System.out.println(list.getSize());


    }
}
