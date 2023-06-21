package com.regex;

import java.util.regex.Pattern;

public class PatternFindExample {
    public static void main(String[] args) {
        String phoneNumber = "jj +380 (33) 970-04-10 dsdsadsf +380 (96) 777-04-10 dfkvkfv" +
                " (096) 999-99-96 dfscdsdc +380 (96) 970-04-10";
//        String regex = "^?(\\+380)? ^?\\(0?\\d{2}\\) \\d{3}-\\d{2}-\\d{2}";
//        String regex = "^?(\\+380)? ^?\\((0?\\d{2})\\) \\d{3}-\\d{2}-\\2";// \\2 means the second group, which is (\\d{2})
        String regex = "^?(\\+380)? ^?\\((?<code>0?\\d{2})\\) \\d{3}-\\d{2}-\\d{2}";// We can also give group a name
//        String regex = "^?(?:\\+380)? ^?\\((?<code>0?\\d{2})\\) \\d{3}-\\d{2}-\\d{2}";// ?: исключает группу из списка групп
        var pattern = Pattern.compile(regex); // Compiles the given regEx into pattern
        var matcher = pattern.matcher(phoneNumber);
        // вывести на экран каждую найденную подстроку
//        while (matcher.find()) { // find() attempts to find the next subsequence of the input sequence that matches the pattern
//            System.out.println(matcher.group()); // Returns the input subsequence matched by the previous match
//        }
//
//        while (matcher.find()) {
//            System.out.println(matcher.group(1)); // returns the subsequence of the first group. A group is what inside the ()
//        }

        while (matcher.find()) {
            System.out.println(matcher.group("code"));
        }

    }
}
