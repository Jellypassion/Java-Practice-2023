package com.streams.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

public class WriterRunner {
    public static void main(String[] args) throws IOException {
        Path path = Path.of("resources", "writer.poem");
//        File file = Path.of("resources", "writer.poem").toFile();
        // Class Files adds many useful static methods for files
        // easy method for writing files
        Files.write(path, List.of("Hello World", "Java"));
        // and easy methods for reading files
        try (Stream<String> lines = Files.lines(path)) { // try-w-resources is needed here
            lines.forEach(System.out::println);
        }
//        try (BufferedWriter fileWriter = Files.newBufferedWriter(path)) {
//            fileWriter.append("Hello World! ");
//            fileWriter.newLine(); // BufferedWriter adds this method
//            fileWriter.append("Java");
//            fileWriter.newLine();
//        }
    }
}
