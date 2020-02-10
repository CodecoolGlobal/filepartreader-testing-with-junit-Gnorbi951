package com.codecool.norbi.junit;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FileWordAnalyzer {
    private FilePartReader reader;

    public FileWordAnalyzer(FilePartReader reader) {
        this.reader = reader;
    }

    public List<String> getWordsOrderedAlphabetically() throws IOException {
        String[] input = reader.readLines().split(" ");
        List<String> unorderedList = new ArrayList<>();
        // This is for filling the list with the words
        for (String word : input) {
            if (word.contains("\n")) {
                // TODO: If word contains , delete it
                String[] splitWord = word.split("\n");
                unorderedList.add(splitWord[0]);
            } else {
                unorderedList.add(word);
            }
        }

        //Collections.sort(unorderedList);
        return unorderedList; // That is ordered
    }

}
