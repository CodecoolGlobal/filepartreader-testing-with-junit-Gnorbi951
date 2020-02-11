package com.codecool.norbi.junit;


import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        FilePartReader reader = new FilePartReader();
        reader.setup("C:\\Codecool\\OOP\\5th_SI\\filepartreader-testing-with-junit-Gnorbi951\\test.txt", 1,3);
        System.out.println(reader.readLines());
        FileWordAnalyzer analyzer = new FileWordAnalyzer(reader);
        List<String> orderedAlphabetically =  analyzer.getWordsOrderedAlphabetically();
        System.out.println(orderedAlphabetically.toString());
        List<String> subStringArray = analyzer.getWordsContainingSubstring("no");
        System.out.println(subStringArray);


    }

}
