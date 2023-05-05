package com.oop.principles;

public class Laptop extends Computer {

    private int weight;

    public Laptop(Ssd ssd, Ram ram, int weight) {
        super(ssd, ram);
        this.weight = weight;
    }

    public void open() {
        System.out.println("Крышка открыта!");
    }

    public int getWeight() {
        return weight;
    }

}
