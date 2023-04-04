package org.example;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.example.Main.*;

public class MainTest {

    Main main = new Main();

    @BeforeEach
    void beforeEach() {
        System.out.println();
    }

    @AfterAll
    static void afterAll() {
        System.out.println();
    }

    // Определить на основе числа месяца какое это время года
    @Test
    void getYearTimeBasedOnMonth() {
        int month = 10;
        if (month == 12 || month == 1 || month == 2) {
            System.out.println("Winter");
        } else if (month == 3 || month == 4 || month == 5) {
            System.out.println("Spring");
        } else if (month == 6 || month == 7 || month == 8) {
            System.out.println("Summer");
        } else if (month == 9 || month == 10 || month == 1) {
            System.out.println("Autumn");
        } else {
            System.out.println("Incorrect month");
        }
    }

    // Дано целое число. Определить является ли последння цифра этого числа - цифрой 3
    @Test
    void checkIfThree() {
        int number = 32373123;
        if (number % 10 == 3) {
            System.out.println("Yes");
        } else System.out.println("No");
    }

    /**
     * 3. Имеется целое число. Это число - сумма денег в рублях.
     * Вывести это число, добавив к нему слово "рубль" в правильном падеже ("рубль", "рублей", "рубля")
     */
    @Test
    void rubles() {
        int amount = 1115;
        if (amount % 10 == 1 && amount % 100 != 11) {
            System.out.println(amount + " рубль");
        } else if ((amount % 10 >= 2 && amount % 10 <= 4) && (amount % 100 < 12 || amount % 100 > 14)) {
            System.out.println(amount + " рубля");
        } else {
            System.out.println(amount + " рублей");
        }

    }

    /**
     * 4. Написать программу, которая считывает год, введённый пользователем, и определяет,
     * является ли этот год високосным.
     * Год считается високосным, если он делится без остатка на 4. Однако, если год также делится на 100,
     * то этот год не високосный, за исключением годов, делящихся на 400.
     * Например:
     * 1992 - високосный
     * 1900 - не високосный
     * 2000 – високосный
     */
    @Test
    void highYear() {
        int year = 1992;
//        if (year % 4 == 0){
//            if (year % 100 == 0 && year % 400 == 0) {
//                System.out.println("високосный");
//            } else if (year % 100 == 0) {
//                System.out.println("не високосный");
//            } else {
//                System.out.println("високосный");
//            }
//        }
        if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0))
            System.out.println("високосный");
        else
            System.out.println("не високосный");

    }

    // switch operator
    @Test
    void switchTest() {
        int value = 4;
        char cahrValue = switch (value) {
            case 1 -> '1';
            case 2, 3, 4 -> '2';
            default -> '0';
        };
    }

    /* Написать программу высчитывающую факториал введённого целого числа. */
    @Test
    int fact() {
        var n = 5;
        var fact = 1;
        for (int i = 1; i <= n; i++) {
            System.out.print(i + " ");
            fact *= i;
        }
        System.out.println("\n" + "f" + n + " = " + fact);
        return fact;
    }

    @Test
    void factRecursionTest() {
        var number = 4;
        var factorial = getFactorialUsingRecursion(number);
        System.out.println(factorial);
        assertThat(factorial).isEqualTo(2 * 3 * 4);
    }

    @Test
    void factorialMethodTest() {
        System.out.println(main.getFactorial(5));
    }

    //    Имеется число. Посчитать сумму цифр данного числа.
    @Test
    void sumOfIntsWhile() {
        var number = 1212;
        var sum = 0;

        while (number != 0) {
            sum += number % 10;
            number /= 10;
        }
        System.out.println(sum);
    }

    @Test
    void sumOfIntsFor() {
        var number = 121212;
        var sum = 0;

        for (int curValue = number; curValue != 0; curValue /= 10) {
            sum += curValue % 10;
        }
        System.out.println(sum);
    }

    /*3. В 1626 году индейцы продали Манхэттен за 24$.
   Написать программу, которая высчитывает сумму,
   получившуюся бы в текущем году, если бы индейцы положили эти
   деньги в банк под 5% годовых.*/
    @Test
    void calcManhPrice() {
        var year = 1627;
        var price = 24;
        var sum = 24.0;

        while (year != 2024) {
            // sum += price * 0.05;
            var percent = sum * 0.05;
            sum += percent;
            System.out.println("year: " + year + " sum: " + sum);
            year++;
        }
        System.out.println(sum);
    }

    /*Написать программу, определяющую, является ли введённое
   целое число простым, т.е. делится без остатка только на 1 и само
   на себя.*/
    @Test
    void checkIfIntIsSimple() {
        var number = 12;
        var isSimple = true;
        for (int i = number - 1; i > 1; i--) {
            if (number % i != 0)
                continue;
            System.out.println("Not Simple! " + i);
            isSimple = false;
            break;
        }
        if (isSimple) {
            System.out.println(number + " is simple!");
        }
    }

    /*Написать программу, которая проходит циклом по английскому
    алфавиту, начиная с буквы ‘b’, и выводит каждую букву до тех пор,
    пока не встретит гласную (т.е. вывести согласные на консоль).*/
    @Test
    void printLetters() {
        for (char i = 'b'; !isVowel(i); i++) {
            System.out.print(i + " " + "\n");
        }
    }

    @Test
    void print2DArrayTest() {
        int[][] values = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[][] values2 = new int[3][];
        values2[0] = new int[5];
        values2[1] = new int[3];
        values2[2] = new int[8];
        values2[2][1] = 3;

        print2DArray(values2);
    }

    /*
        Написать программу, которая печатает массив сначала в обычном порядке, затем в обратном.
    */
    @Test
    void printArrayTwoWays() {
        var array = new int[]{1, 2, 4};
        printIntArray(array);
        System.out.println();
        for (int i = array.length - 1; i >= 0; i--) {
            System.out.print(array[i] + " ");
        }
    }

    /*Написать программу, заносящую в массив первые 100 целых чисел, делящихся на 13 или на 17, и печатающую его.*/
    @Test
    void dividersArray() {
        var array = new int[100];
        var initialNumber = 1;
        for (int i = 0; i <= array.length; i++) {
            for (int j = initialNumber; j > 0; j++) {
                if (i == array.length) {
                    break;
                }
                if (j % 13 == 0 || j % 17 == 0) {
                    array[i] = j;
                    initialNumber = j + 1;
                    break;
                }
            }
        }
        printIntArray(array);
    }

    @Test
    void isEqualElementsTest() {
        int[][] values1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8}
        };
        int[][] values2 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8}
        };
        System.out.println(isEqualElements(values1, values2));
    }

    @Test
    void calculateSumMinMaxTest() {
        // has to calculate sum of 5, 6, 4
        var array = new int[]{1, 2, 10, 5, 6, 4, 0};
        System.out.println(calculateSumMinMax(array));
    }



}
