package org.example;

public class StringsPractice {
    /**
     * 1. Заменить все грустные смайлы :( в строке на весёлые :)
     */
    public static String changeSmiles(String string) {
        if (string.contains(":(")) {
            return string.replace(":(", ":)");
        } else {
            System.out.println("No sad smiles in this string...");
            return string;
        }
    }

    /**
     * 2. Написать функцию, принимающую 2 параметра: строку и слово - и
     * возвращающую true, если строка начинается и заканчивается этим словом.
     */
    public static boolean checkStringForWords(String string, String word) {
//        var split = string.split(" ");
//        return (split[0].equalsIgnoreCase(word) && split[split.length-1].equals(word));
        return string.startsWith(word) && string.endsWith(word);
    }

    /**
     * 3. Написать функцию, принимающую в качестве параметров имя, фамилию и
     * отчество и возвращающую инициалы
     * в формате "Ф.И.О". Учесть, что входные параметры могут быть в любом
     * регистре, а результирующая строка должна быть в верхнем.
     **/
    public static String getInitials(String firstName, String lastName, String fatherName) {
        //v1
//        return
//                lastName.substring(0, 1).toUpperCase() + "." +
//                        firstName.substring(0, 1).toUpperCase() + "." +
//                        fatherName.substring(0, 1).toUpperCase() + ".";
        //v2
//        return String.format("%s.%s.%s", lastName.toUpperCase().charAt(0),
//                firstName.toUpperCase().charAt(0),
//                fatherName.toUpperCase().charAt(0));
        //v3
        return String.format("%s.%s.%s", Character.toUpperCase(lastName.charAt(0)),
                Character.toUpperCase(firstName.charAt(0)),
                Character.toUpperCase(fatherName.charAt(0)));

    }

    /**
     * 4. Подсчитать количество всех точек, запятых и восклицательных знаков в
     * строке.
     **/
    public static int countPunctuationMarks(String string) {
//        var resultsMap = new HashMap<String, Integer>(3);
        var counter = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == '.' || string.charAt(i) == ',' || string.charAt(i) == '!')
                counter++;
        }
        return counter;
    }

    /**
     * 5. Написать функцию, разбивающую строку на равные части по n символов и
     * сохраняющую отдельные части в массив. Вывести этот массив.
     **/
    public static String[] split(String value, int numberOfSymbols) {
        int arraySize = (int) Math.ceil(value.length() / (double) numberOfSymbols);
        String[] strArray = new String[arraySize];
        int counter = 0;
        for (int i = 0; i < value.length(); i += numberOfSymbols) {
            int endIndex = Math.min(value.length(), i + numberOfSymbols);
            strArray[counter] = value.substring(i, endIndex);
            counter++;
        }
        return strArray;
    }


}
