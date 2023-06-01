package com.streams.io;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;


public class OutputRunner {
    public static void main(String[] args) throws IOException {
        File file = Path.of("resources", "outTest.txt").toFile();
        // second parameter is append. When false - overwrites file; when true - adds data to the end of file
        try (var fileOutputStream = new BufferedOutputStream(new FileOutputStream(file, true))) {
            String value = "Hello World!";
            fileOutputStream.write(value.getBytes());
            fileOutputStream.write(System.lineSeparator().getBytes()); // used for moving the caret to the next line (when data is added at the end)
        }
    }
}
