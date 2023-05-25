package com.collections.map;

import com.collections.person.Person;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapExample {
    public static void main(String[] args) {
        Person ivan = new Person(1, "Ivan", "Petrov");
        Person petro = new Person(2, "Petro", "Ivanov");
        Person sveta = new Person(21, "Sveta", "Svetikova");
        Person sveta2 = new Person(10, "Sveta", "Svetikova");
        Person sveta3 = new Person(18, "Sveta", "Svetikova");
        Person sveta4 = new Person(46, "Sveta", "Svetikova");
        Person sveta5 = new Person(9, "Sveta", "Svetikova");
        Person sveta6 = new Person(5, "Sveta", "Svetikova");

        // In TreeMap the elements are automatically sorted by key
        Map<Integer, Person> map = new TreeMap<>();
        map.put(ivan.getId(), ivan);
        map.put(petro.getId(), petro);
        map.putIfAbsent(sveta.getId(), sveta);
        map.putIfAbsent(sveta2.getId(), sveta2);
        map.putIfAbsent(sveta3.getId(), sveta3);
        map.putIfAbsent(sveta4.getId(), sveta4);
        map.putIfAbsent(sveta5.getId(), sveta5);
        map.putIfAbsent(sveta6.getId(), sveta6);

        for (Map.Entry<Integer, Person> entry : map.entrySet()) {
            System.out.println(
                    entry.getKey() + " = " +
                    entry.getValue().getFirstName() + " " +
                    entry.getValue().getLastName()
            );
        }

    }

}
