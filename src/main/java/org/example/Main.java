package org.example;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public static boolean isVowel(char c) {
        return "AEIOUaeiou".indexOf(c) != -1;
    }

    public int getFactorial(int value) {
        var fact = 1;
        for (int i = 1; i <= value; i++) {
            System.out.print(i + " ");
            fact *= i;
        }
        System.out.println("\n" + "f" + value + " = " + fact);
        return fact;
    }

    public static int getFactorialUsingRecursion(int value) {
        if (value == 1) {
            return 1;
        }

        return value * getFactorialUsingRecursion(value - 1);
    }

    public static void printIntArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
    }

    public static void print2DArray(int[][] array) {
        for (int[] i : array) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    /*Написать метод equals, который определяет, равны ли между собой соответствующие элементы
   2-х двумерных массивов.*/
    public static boolean isEqualElements(int[][] array1, int[][] array2) {
        boolean isEqual = true;
        if (array1.length != array2.length) {
            return false;
        }
        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array1[i].length; j++) {
                if (array1[i].length != array2[i].length) {
                    isEqual = false;
                    break;
                } else if (array1[i][j] != array2[i][j]) {
                    isEqual = false;
                    break;
                }
            }
            if (!isEqual)
                break;
        }
        return isEqual;
    }


}