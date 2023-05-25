package com.collections.practice;

import java.util.*;

public class CollectionsPractice {
    public static void main(String[] args) {

    }

    /**
     * 1. Написать метод, который принимает целочисленный список и возвращает
     * целочисленный список только с нечетными значениями.
     */
    public static List<Integer> returnOddsOnly(List<Integer> list) {
        List<Integer> oddsList = new ArrayList<>();
        for (Integer n : list) {
            if (n % 2 != 0) {
                oddsList.add(n);
            }
        }
        return oddsList;
    }

    /*2. Написать метод countUnique, который принимает целочисленный
    списк в качестве параметра и возвращает количество уникальных
    целых чисел в этом списке.
    При получении пустого списка метод должен возвращать 0.
    Пример:
            [3, 7, 3, -1, 2, 3, 7, 2, 15, 15] вернёт 5.*/
    public static int countUnique(List<Integer> list) {
// V.1
//        var workingList = new ArrayList<>(list);
//        var uniqueList = new ArrayList<>();
//        for (Integer n : list) {
//            uniqueList.add(n);
//            workingList.remove(n);
//            if (workingList.contains(n)) {
//                uniqueList.remove(n);
//            }
//        }
//        return uniqueList.size();

//        V.2
        return new HashSet<>(list).size();
    }

    /*3. Написать метод isUnique, который принимает Map&lt;String, String&gt;
    и возвращает true,
    если каждому ключу соответствуют свое уникальное значение.
            Например, в данном случае вернётся true:
    {Marty=Stepp, Stuart=Reges, Jessica=Miller, Amanda=Camp,
            Hal=Perkins}
    А в данном false:
    {Kendrick=Perkins, Stuart=Reges, Jessica=Miller, Bruce=Reges,
            Hal=Perkins}*/
    public static boolean isUnique(Map<String, String> map) {
        return new HashSet<>(map.values()).size() == map.size();
    }

    /*4. Сложить два многочлена заданной степени, если коэффициенты
    многочлена хранятся в объекте HashMap в виде:
    Ключ: номер степени
    Значение: значение множителя
    Вывести результирующий многочлен в виде строки: ax^6 + bx^4 +
    cx^3 + dx + 8*/
    public static Map<Integer, Integer> polynomialAdding(Map<Integer, Integer> polynomial1,
                                                         Map<Integer, Integer> polynomial2) {
        Map<Integer, Integer> polynomialResult = new HashMap<>(polynomial1);
        for (Map.Entry<Integer, Integer> entry : polynomial2.entrySet()) {
//            var value = polynomialResult.getOrDefault(entry.getKey(), 0);
//            polynomialResult.put(entry.getKey(), value + entry.getValue());
            polynomialResult.merge(entry.getKey(), entry.getValue(), (newValue, oldValue) -> newValue + oldValue);

        }

        return polynomialResult;
    }

    public static String convertPolynomialToString(Map<Integer, Integer> map) {
        Map<Integer, Integer> result = new TreeMap<>(Comparator.reverseOrder());
        result.putAll(map);
        List<String> list = new ArrayList<>(result.size());
        for (Map.Entry<Integer, Integer> entry : result.entrySet()) {
            var value = entry.getKey() == 0
                    ? String.valueOf(entry.getValue())
                    : entry.getValue() + "x^" + entry.getKey();
            list.add(value);
        }
        return String.join(" + ", list);
    }


}
