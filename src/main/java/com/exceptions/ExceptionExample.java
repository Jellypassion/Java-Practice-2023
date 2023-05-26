package com.exceptions;

import java.io.FileNotFoundException;
import java.util.concurrent.TimeoutException;

public class ExceptionExample {

    public static void main(String[] args) {
        System.out.println("main start");
        try {
            unsafeMethod(10);
        // if multiple exceptions need to be handled in the same way, they can be combined in one catch block
        } catch (FileNotFoundException | TimeoutException exception) {
        // this block is for handling exception
            exception.printStackTrace();
        // multiple catch blocks can also be implemented
//         Parent class "Exception" can be provided as a parameter for catch block when we need to catch multiple exceptions
        } finally { // this block is always being executed
            System.out.println("Finally block");
        }
        System.out.println("main end");
        // some code
    }

    // throws means that this method throws some exception
    public static void unsafeMethod(int value) throws FileNotFoundException, TimeoutException {
        System.out.println("unsafeMethod start");
        if (value > 0) {
            throw new FileNotFoundException();
        } else if (value < 0) {
            throw new RuntimeException(); // RuntimeException and its descendants do not need to be processed on a method level (no need to indicate it with "throws")
        }
        System.out.println("unsafeMethod end");
    }

}
