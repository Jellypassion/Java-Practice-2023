package com.programming.functional.practice;


import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.*;

public class Task5 {
    public static void main(String[] args) {
        /*5. Дан класс Person с полями firstName, lastName,
        age.
                Вывести полное имя самого старшего человека, у
        которого длина этого имени не превышает 15
        символов.*/
        List<Person> persons = List.of(
                new Person("Ivan", "Ivanov", 20),
                new Person("Petro", "Petrov", 30),
                //new Person("Kate", "Ivanova", 30),
                new Person("Sergey", "Sergeeyev", 40),
                new Person("Stepan", "Stepanov", 50)
        );
        // v1
//        persons.stream()
//                .filter(it -> it.getFullName().length() < 15)
////                .peek(it -> System.out.println("Filtered: " + it))
//                .reduce((person1, person2) -> person1.getAge() > person2.getAge() ? person1 : person2)
//                .ifPresent(it -> System.out.println(it.getFullName()));
//
        // v2
        persons.stream()
                .filter(it -> it.getFullName().length() < 15)
                .max(Comparator.comparing(Person::getAge))
                .map(Person::getFullName)
                .ifPresent(System.out::println);


        // Представить список людей в виде мапы, где ключом будет возраст
        var people = persons.stream()
                .collect(
                        groupingBy(Person::getAge,
                                mapping(Person::getFullName,
                                        toList())));
        System.out.println(people);

        // Get the map of people
        Map<Integer, Person> peopleMap = persons.stream()
                .collect(toMap(Person::getAge, Function.identity())); // identity returns the object itself
        System.out.println(peopleMap);

    }
}
