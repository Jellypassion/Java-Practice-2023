package com.collections.map;

import com.collections.person.Person;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortExample {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("123", "69", "23", "32");
        Collections.sort(strings); // sorts the list in alphabetic order
//        System.out.println(strings);

        var personsList = Arrays.asList(
                new Person(1, "Ivan", "Ivanov"),
                new Person(123, "Petro", "Petrov"),
                new Person(14, "Sveta", "Svetikova")
        );
        // To use Collections.sort, class Person should implement Comparable<Person> interface.
        // Implemented method compareTo may look like this:
//        @Override
//        public int compareTo(Person o) {
//            return Integer.compare(id, o.id);
//        }
        Collections.sort(personsList);
        System.out.println(personsList);
        // Fof this, a new class which implements Comparator<Person> interface should be created
        personsList.sort(new FirstNameComparator());
        // another way to compare by name (and the shortest one)
        personsList.sort(Comparator.comparing(Person::getFirstName).thenComparing(Person::getLastName));
        System.out.println(personsList);

    }

    public static class FirstNameComparator implements Comparator<Person> {

        @Override
        public int compare(Person o1, Person o2) {
            return o1.getFirstName().compareTo(o2.getFirstName());
        }
    }

}
