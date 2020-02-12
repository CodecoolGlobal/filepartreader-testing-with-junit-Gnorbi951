package com.codecool.norbi.junit;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileWordAnalyzerTest {
    FilePartReader reader = new FilePartReader();

    @org.junit.jupiter.api.Test
    public void constructorGetsArgumentFromFilePartReader() {
        FileWordAnalyzer analyzer = new FileWordAnalyzer(reader);
        assertNotNull(analyzer);
    }

    @org.junit.jupiter.api.Test
    public void wordsGetOrderedAlphabetically() throws IOException {
        reader.setup("C:\\Codecool\\OOP\\5th_SI\\filepartreader-testing-with-junit-Gnorbi951\\test.txt", 1,3);
        FileWordAnalyzer analyzer = new FileWordAnalyzer(reader);
        List<String> result = analyzer.getWordsOrderedAlphabetically();
        List<String> expected = new ArrayList<>(Arrays.asList("According", "a", "abba", "all",
                                                "aviation", "bee", "is", "known", "laws", "no", "to", "way"));
        assertEquals(result, expected);
    }

    @org.junit.jupiter.api.Test
    public void returnWordsContainingSubstring() throws IOException {
        reader.setup("C:\\Codecool\\OOP\\5th_SI\\filepartreader-testing-with-junit-Gnorbi951\\test.txt", 1,10);
        FileWordAnalyzer analyzer = new FileWordAnalyzer(reader);
        List<String> result = analyzer.getWordsContainingSubstring("win");
        List<String> expected = new ArrayList<>(Collections.singletonList("wings"));

        assertEquals(result, expected);
    }

    @org.junit.jupiter.api.Test
    public void findsPalindrome() throws IOException {
        reader.setup("C:\\Codecool\\OOP\\5th_SI\\filepartreader-testing-with-junit-Gnorbi951\\test.txt", 1,3);
        FileWordAnalyzer analyzer = new FileWordAnalyzer(reader);
        List<String> result = analyzer.getStringsWhichPalindromes();
        List<String> expected = new ArrayList<>(Collections.singletonList("abba"));
        assertEquals(result, expected);
    }
}