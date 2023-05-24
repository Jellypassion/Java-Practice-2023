package com.collections.person;

public class PersonExample {
    public static void main(String[] args) {
        var ivan = new Person(1, "Ivan", "Petrov");
        var petro = new Person(2, "Petro", "Ivanov");

        System.out.println(ivan.hashCode());
        System.out.println(petro.hashCode());
        System.out.println(ivan.equals(petro));
    }
}
