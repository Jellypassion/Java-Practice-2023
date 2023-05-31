package com.programming.functional.practice;

import java.util.List;

public class Task2 {

    public static void main(String[] args) {
        /*2. Дан список строк. Найти количество уникальных
        строк длиной более 8 символов.*/
        var strings = List.of(
                "abcdefghi",
                "abc",
                "abcdefghij",
                "aaaaaaaaaa",
                "aaaaaaaaaa"
        );
        // v1
//        var stringSet = strings.stream()
//                .filter(it -> it.length() > 8)
//                .collect(Collectors.toSet());
//        System.out.println(stringSet);
//        System.out.println("size: " + stringSet.size());

        // v2
        var count = strings.stream()
                .filter(it -> it.length() > 8)
                .distinct() // removes duplicates
                .count();
        System.out.println(count);

    }

}
