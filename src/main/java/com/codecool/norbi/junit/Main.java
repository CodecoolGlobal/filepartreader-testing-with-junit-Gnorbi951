package com.codecool.norbi.junit;


import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        FilePartReader reader = new FilePartReader();
        reader.setup("C:\\Codecool\\OOP\\5th_SI\\filepartreader-testing-with-junit-Gnorbi951\\README.md", 1,1);
        System.out.println(reader.read());
    }

}
