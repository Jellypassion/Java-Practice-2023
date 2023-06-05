package com.serialization;

import java.io.Serial;
import java.io.Serializable;

// In order to serialize objects, this class has to implement a Serializable interface
public class Person implements Serializable {
//    Without a serialVersionUID field, any change to the class will make previously serialized versions unreadable.
    @Serial
    private static final long serialVersionUID = 1L;
//    In order to avoid serialization of the field it must be indicated as transient
    private transient int age;
    private String firstName;

    public Person(int age, String firstName) {
        this.age = age;
        this.firstName = firstName;
    }

    public int getAge() {
        return age;
    }

    public String getFirstName() {
        return firstName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", firstName='" + firstName + '\'' +
                '}';
    }
}
