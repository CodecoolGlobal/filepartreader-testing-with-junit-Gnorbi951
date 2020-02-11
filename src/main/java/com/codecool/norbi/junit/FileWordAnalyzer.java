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
            processWord(unorderedList, word);
        }

        Collections.sort(unorderedList);
        return unorderedList; // That is ordered
    }

    private void processWord(List<String> unorderedList, String word) {
        if (word.contains("\n")) {
            String[] splitWord = word.split("\n");
            if (splitWord[0].contains(",")) {
                String rightString = "";
                for (int i = 0; i < splitWord[0].length(); i++) {
                    char currentChar = splitWord[0].charAt(i);
                    if (currentChar != ',') {
                        rightString += currentChar;
                    }
                }
                unorderedList.add(rightString);
            } else {
                unorderedList.add(splitWord[0]);
            }
        } else {
            unorderedList.add(word);
        }
    }

}
