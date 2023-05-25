package com.collections.map;

import com.collections.person.Person;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapExample {
    public static void main(String[] args) {
        Person ivan = new Person(29, "Ivan", "Petrov");
        Person petro = new Person(16, "Petro", "Ivanov");
        Person sveta = new Person(23, "Sveta", "Svetanova");
        Map<Integer, Person> map = new LinkedHashMap<>();
        // In LinkedHashMap the entries are stored in the order that they were added
        map.put(ivan.getId(), ivan);
        map.put(petro.getId(), petro);
        map.put(sveta.getId(), sveta);
        for (Map.Entry<Integer, Person> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

    }


}
