package com.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternExample {
    public static void main(String[] args) {
        String phoneNumber = "+380 (96) 970-04-10";
//        \\+ используется для экранирования, поскольку + это зарезервированный символ, а нужно его использовать просто как +
//        Экранирование используется для специальных метасимволов напр. "(", ")", "{", "}", "[", "]" и для квантификаторов
//        Но если мы хотим чтоб буква ипользовалась как спецсимвол, ее также нужно экранировать
        Pattern pattern = Pattern.compile("\\+380 \\(\\d{2}\\) \\d{3}-\\d{2}-\\d{2}");// Compiles the regExp into pattern.
        // Creates a matcher that will match the given input against this pattern
        Matcher matcher = pattern.matcher(phoneNumber);
        // Returns true if, and only if, the entire region sequence matches this matcher's pattern
        System.out.println(matcher.matches());
// Simpler way to check if pattern matcher a String (using method of the Pattern class)
        String regex = "\\+380 \\(\\d{2}\\) \\d{3}-\\d{2}-\\d{2}";
        System.out.println(Pattern.matches(regex, phoneNumber));
// Another way to check it (using method from String class)
        System.out.println(phoneNumber.matches(regex));

    }
}
