package com.serialization;

import java.io.*;
import java.nio.file.Path;

public class SerializationDemo {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        var path = Path.of("resources", "person.out");
        var person = new Person(26, "Sergey");
//        serializePerson(path, person);
        deserializePerson(path);
    }

    private static void serializePerson(Path path, Person person) throws IOException {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path.toFile()))) {
            objectOutputStream.writeObject(person);
        }
    }

    private static void deserializePerson(Path path) throws IOException, ClassNotFoundException {
        try (var objectInputStream = new ObjectInputStream(new FileInputStream(path.toFile()))) {
            var object = objectInputStream.readObject();
            System.out.println(object);
        }
    }

}
