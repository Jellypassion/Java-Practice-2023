package com.streams.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.stream.Collectors;

public class ReaderRunner {
    public static void main(String[] args) throws IOException {
        var file = Path.of("resources", "test.txt").toFile();
        // Class FileReader is used for working with text files
        try (BufferedReader fileReader = new BufferedReader(new FileReader(file))) { // BufferReader adds more useful methods than FileReader
            String collected = fileReader.lines() // returns a stream of lines
                    .map(String::toUpperCase)
                    .collect(Collectors.joining("\n"));
            System.out.println(collected);
        }
    }
}
