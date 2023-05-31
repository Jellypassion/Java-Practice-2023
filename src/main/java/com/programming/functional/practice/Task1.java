package com.programming.functional.practice;

import java.util.List;

public class Task1 {

    public static void main(String[] args) {
       /* 1. Дан список целых чисел. Найти среднее всех
        нечётных чисел, делящихся на 5.*/
        var list = List.of(1, 3, 5, 8, 15, 35, 32, 20);
        list.stream()
                .filter(it -> it % 2 != 0)
                .peek(e -> System.out.println("Filtered value: " + e))
                .filter(it -> it % 5 == 0)
                .peek(e -> System.out.println("Filtered value 2: " + e))
                .mapToInt(Integer::intValue)
                .average()
                .ifPresent(avg -> System.out.println("Average value: " + avg));

    }

}
