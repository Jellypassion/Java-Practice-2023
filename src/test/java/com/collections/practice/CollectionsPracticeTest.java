package com.collections.practice;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static com.collections.practice.CollectionsPractice.*;

public class CollectionsPracticeTest {
    @AfterAll
    static void afterAll() {
        System.out.println();
    }

    @BeforeEach
    void beforeEach() {
        System.out.println();
    }

    @Test
    void returnOddsOnlyTest() {
//        var list1 = Arrays.asList(1, 3, 4, 6);
        // creates immutable list
        var list = List.of(1, 3, 4, 6);
        System.out.println("Initial List:\n" + list);
        System.out.println("List with Odds only:\n" + returnOddsOnly(list));
    }

    @Test
    void countUniqueTest() {
        var list = List.of(3, 7, 3, -1, 2, 3, 7, 2, 15, 15);
        System.out.println(countUnique(list));
    }

    @Test
    void isUniqueTest() {
        var map1 = Map.of("Marty", "Stepp",
                "Stuart", "Reges",
                "Jessica", "Miller",
                "Amanda", "Camp",
                "Hal", "Perkins");

        var map2 = Map.of("Kendrick", "Perkins",
                "Stuart", "Reges",
                "Jessica", "Miller",
                "Bruce", "Reges",
                "Hal", "Perkins");

        System.out.println(isUnique(map2));
    }

    @Test
    void polynomialAddingTest() {
        var polynomial1 = Map.of(
                0, 5,
                1, 3,
                3, 2,
                5, 4,
                6, 7
        );
        var polynomial2 = Map.of(
                0, 5,
                3, 4,
                5, 5,
                6, 1
        );
        // 8x^6 + 9x^5 + 6x^3 +3x^1 + 10
        Map<Integer,Integer> sum = polynomialAdding(polynomial1, polynomial2);
        System.out.println(convertPolynomialToString(sum));
    }


}
