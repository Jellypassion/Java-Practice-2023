package com.enums;

public class List<T> {

    private T[] objects;
    private int size;

    public List(int initialSize) {
        this.objects = (T[]) new Object[initialSize];
    }

    public void add(T element) {
        if (size == objects.length) {
            System.out.println("Cannot add the element: " + element + ". The list is full");
        } else
            objects[size++] = element;
    }

    public T get(int index) {
        return objects[index];
    }

    public int getSize() {
        return size;
    }
}
