package com.streams.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;

public class InputStreamRunner {
    public static void main(String[] args) throws IOException, FileNotFoundException {
//        File file = new File("resources/file.txt");
        File file = Path.of("resources", "test.txt").toFile(); // More safe way of indicating the path
        try (var fileInputStream = new FileInputStream(file)) { // Should be in try-w-resources block so that input stream could be automatically closed
            byte[] bytes = new byte[fileInputStream.available()];
            int counter = 0;
            byte currentByte;
            while((currentByte = (byte) fileInputStream.read()) != -1) {
                bytes[counter++] = currentByte;
            }
            String strValue = new String(bytes);
            System.out.println(strValue);
//            byte[] bytes = fileInputStream.readAllBytes(); // reads file as bytes
//            var asString = new String(bytes); // String's constructor which accepts bytes
//            System.out.println(asString);
        }

    }
}
