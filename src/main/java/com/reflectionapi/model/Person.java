package com.reflectionapi.model;

public abstract class Person {

    private Long id;

    public Person(Long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                '}';
    }
}
