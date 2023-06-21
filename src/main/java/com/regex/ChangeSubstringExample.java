package com.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChangeSubstringExample {
    public static void main(String[] args) {
        String phoneNumber = "jj +380 (33) 970-04-10 dsdsadsf +380 (96) 777-04-10 dfkvkfv" +
                " +380 (96) 999-99-96 dfscdsdc +380 (96) 970-04-10 nvnc";
        String regex = "(?:\\+380) \\((\\d{2})\\) (\\d{3})-(\\d{2})-(\\d{2})";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNumber);
        StringBuffer stringBuffer = new StringBuffer(); // StringBuffer это потокобезопасный аналог StringBuilder'a
        while (matcher.find()) {
            matcher.appendReplacement(stringBuffer, "XXX");
        }
        matcher.appendTail(stringBuffer);// Appends the end of the string, otherwise "nvnc" will be lost
        System.out.println(stringBuffer);// jj XXX dsdsadsf XXX dfkvkfv XXX dfscdsdc XXX nvnc
        // Another way to replace substring of a string
        // $1 - means the index of a group
        System.out.println(phoneNumber.replaceAll(regex, "0$1 $2 $3 $4"));// jj 033 970 04 10 dsdsadsf 096 777 04 10 dfkvkfv 096 999 99 96 dfscdsdc 096 970 04 10 nvnc

    }
}
