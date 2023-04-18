package org.example;

public class StringsPractice {
    /**
     * 1. Заменить все грустные смайлы :( в строке на весёлые :)
     */
    public static String changeSmiles(String string) {
        if (string.contains(":(")) {
            var newString = string.replace(":(", ":)");
            return newString;
        } else {
            System.out.println("No sad smiles in this string...");
            return string;
        }


    }
}
