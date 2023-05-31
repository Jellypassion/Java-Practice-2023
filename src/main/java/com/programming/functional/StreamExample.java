package com.programming.functional;

import java.util.List;
import java.util.stream.IntStream;

public class StreamExample {
    public static void main(String[] args) {
        List<String> strings = List.of("11", "88", "22", "33", "44", "55", "66");
//        var statistics = strings.stream()
//                .map(it -> it + it)
//                .map(Integer::valueOf)
//                .filter(value -> value % 2 == 0)
//                .sorted(Comparator.reverseOrder())
////                .skip(1)
////                .limit(2)
//                .mapToInt(Integer::intValue) // this function creates a stream of ints (primitive types)
//                .summaryStatistics();// Streams of primitives have some additional useful methods
////        System.out.println(statistics);
////                .forEach(System.out::println);
//        // Another ways to create streams:
//        IntStream.of(1, 2, 3, 4, 5); // stream of ints


//        var stringList = Stream.of("a", "b", "c") // stream of objects
//                .peek(System.out::println) // This operation works like forEach, but it is intermediate
//                .toList();

//        IntStream.range(0, 11)
//                .forEach(System.out::println);

        IntStream.iterate(0, operand -> operand + 3) // creates a stream of ints (0, 3, 6, 9 .....)
                .skip(10)
                .limit(20)
                .forEach(System.out::println);
    }


}
