package org.example;

import org.junit.jupiter.api.Test;

import static org.example.StringsPractice.*;

public class StringsPracticeTest {

    @Test
    void changeSmilesTest() {
        var string = "hello:( :( :( gag";
        System.out.println("Old String: " + string);
        System.out.println("New String: " + changeSmiles(string));
    }

}
