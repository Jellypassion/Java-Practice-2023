package com.streams.io;

import java.io.File;
import java.io.IOException;

public class FileRunner {
    public static void main(String[] args) throws IOException {

        File file = new File("resources/test.txt");
        System.out.println("Create file: " + file.createNewFile()); // method which creates this file

        System.out.println(file.exists()); // returns boolean if file exists or not
        System.out.println(file.isFile()); // checks if it is a file
        System.out.println(file.isDirectory()); // checks if it is a directory
        System.out.println(file.getName()); // get file name
        System.out.println(file.getParent()); // get the parent directory
        System.out.println(file.getAbsolutePath()); // get the full path to the file
        System.out.println(file.length()); // get the file size
//        System.out.println(file.delete()); // delete the file

//        File dir = new File("resources/testdir");
//        System.out.println(dir.mkdir()); // A way to create a directory instead of file
//        System.out.println(Arrays.toString(dir.list())); // list all files
//        System.out.println(Arrays.toString(dir.listFiles()));


    }
}
