package com.collections.set;

import java.util.Set;
import java.util.TreeSet;

public class SetExample {
    public static void main(String[] args) {
        // It has random order of elements
        //Set<String> set = new HashSet<>();
        // To keep the order of elements as they were added we need to use LinkedHashSet
        //Set<String> set = new LinkedHashSet<>();
        // To make the elements sorted (alphabetically) we need to use TreeSet. It also can accept a Comparator in its constructor
        Set<String> set = new TreeSet<>();

        set.add("aaa");
        set.add("ddd");
        set.add("bbb");
        set.add("ccc");
        System.out.println(set.add("bbb")); // false

        System.out.println(set);

    }
}
