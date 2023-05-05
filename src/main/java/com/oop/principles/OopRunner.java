package com.oop.principles;

public class OopRunner {

    public static void main(String[] args) {
        Ram ram = new Ram(2048);
        Ssd ssd = new Ssd(500);
        Computer pc1 = new Computer(ssd, ram);
        pc1.load();

        Laptop laptop1 = new Laptop(new Ssd(512), new Ram(4096), 2);
        laptop1.open();
        laptop1.load();

    }
}
