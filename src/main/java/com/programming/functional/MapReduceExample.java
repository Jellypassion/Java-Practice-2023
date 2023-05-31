package com.programming.functional;

import java.util.Optional;
import java.util.stream.Stream;

public class MapReduceExample {

    public static void main(String[] args) {
        Optional<Student> maybeStudent = Stream.of(
                        new Student(18, "Ivan"),
                        new Student(23, "Petro"),
                        new Student(34, "Vasya"),
                        new Student(45, "Sveta"),
                        new Student(20, "Katya"),
                        new Student(68, "Den"),
                        new Student(101, "Kira")
                )
                .parallel() // Streams can be paralleled to increase the operations execution time
//                .map(Student::getAge)
                .filter(student -> student.getAge() >= 18)
                .reduce((student1, student2) -> student1.getAge() > student2.getAge() ? student1 : student2);
//                .ifPresent(student -> System.out.println(student.getName() + " " + student.getAge()));

        maybeStudent.ifPresent(System.out::println);
        maybeStudent.map(Student::getAge)
                .flatMap(age -> Optional.of(age * 2)) // returns optional
                .ifPresent(System.out::println);

    }


}
