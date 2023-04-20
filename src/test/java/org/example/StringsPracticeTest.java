package org.example;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.example.StringsPractice.*;

public class StringsPracticeTest {

    @Test
    void changeSmilesTest() {
        var string = "hello:( :( :( gag";
        System.out.println("Old String: " + string);
        System.out.println("New String: " + changeSmiles(string));
    }

    @Test
    void checkStringForWordsTest() {
        var string = "hello my friend hello";
        var word = "hello";
        System.out.println(checkStringForWords(string, word));
    }

    @Test
    void getInitialsTest() {
        System.out.println(getInitials("Тарас",
                "Шевченко",
                "Григорович"));
    }

    @Test
    void countPunctuationMarksTest() {
        String string = "asdf.,!hgfdsa!,.?aa";
        System.out.println(countPunctuationMarks(string));
    }

    @Test
    void splitTest() {
        var string = "1234567890";
        var n = 3;
        String[] result = split(string, n);
        System.out.println(Arrays.toString(result));
    }

}
