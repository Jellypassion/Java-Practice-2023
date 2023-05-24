package com.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorExample {

    public static void main(String[] args) {
        List<Integer> sourceLlist = List.of(1, 2, 3, 4, 5); // This creates an immutable collection
        List<Integer> list = new ArrayList<>(sourceLlist); // This makes the collection mutable
        Iterator<Integer> iterator = list.iterator();
        list.removeIf(next -> next == 3 || next == 4);
        while (iterator.hasNext()) {
            Integer next  = iterator.next();
            if (next == 3 || next == 4) {
                iterator.remove();
            }
            //System.out.println(next);
        }
        list.forEach(System.out::println);
        //System.out.println(list);
    }


}
