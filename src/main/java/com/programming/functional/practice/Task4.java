package com.programming.functional.practice;

import java.util.List;
import java.util.stream.Collectors;

public class Task4 {
    public static void main(String[] args) {
       /* 4. Дан список целых чисел, вывести строку,
                представляющую собой конкатенацию
        строковых представлений этих чисел.
        Пример: список {5, 2, 4, 2, 1}
        Результирующая строка: "52421"*/
        var ints = List.of(1, 2, 3, 4, 5, 6, 7);

        // v1
//        ints.stream()
//                .map(String::valueOf)
//                .reduce(String::concat)
//                .ifPresent(System.out::println);

        // v2
        var collected = ints.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
        System.out.println(collected);

    }
}
