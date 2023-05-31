package com.programming.functional.practice;

import java.util.Map;

public class Task3 {

    public static void main(String[] args) {
        /*3. Дана Map<String, Integer>. Найти сумму всех
        значений, длина ключей которых меньше 7
        символов.*/
        var map = Map.of(
                "1234567", 1,
                "123", 2,
                "12", 3,
                "12345678", 4,
                "1234", 5
        );
        var sum = map.entrySet().stream()
                .filter(it -> it.getKey().length() < 7)
                .mapToInt(Map.Entry::getValue)
                .sum();
        System.out.println(sum);


    }

}
