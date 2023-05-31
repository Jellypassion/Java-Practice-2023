package com.programming.functional;

import java.util.Comparator;

public class LambdaExample {
    public static void main(String[] args) {
//        Comparator<Integer> comparator = new IntegerComparator();

        // Method compare() can be overridden using lambdas
//        Comparator<Integer> comparator = (i1, i2) -> Integer.compare(i1, i2);

        //Same thing can be replaced using method reference
        Comparator<Integer> comparator = Integer::compare;

        System.out.println(comparator.compare(25, 100));


    }


// Instead of creating a separate class for only one method overriding, lambda expressions can be used directly inside the needed method
    private static class IntegerComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return Integer.compare(o1, o2);
        }
    }
}
