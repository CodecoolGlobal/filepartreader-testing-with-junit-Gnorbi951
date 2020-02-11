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
        List<String> unorderedList = readInputToList();

        Collections.sort(unorderedList);
        return unorderedList; // That is ordered
    }


    public List<String> getWordsContainingSubstring (String subString ) throws IOException {
        List<String> wordList = readInputToList();
        List<String> foundWords= new ArrayList<>();
        for (String word : wordList) {
            if (word.contains(subString)) {
                foundWords.add(word);
            }
        }
        return foundWords;

    }

    public List<String> getStringsWhichPalindromes() throws IOException {
        List<String> wordList = readInputToList();
        List<String> palindromeList = new ArrayList<>();
        for (String word : wordList) {
            StringBuilder reverseWord = new StringBuilder();
            reverseWord.append(word);
            reverseWord = reverseWord.reverse();
            if (reverseWord.toString().equals(word) && word.length()!= 1) {
                palindromeList.add(word);
            }
        }
        return palindromeList;
    }


    private List<String> readInputToList() throws IOException {
        String[] input = reader.readLines().split(" ");
        List<String> unorderedList = new ArrayList<>();
        // This is for filling the list with the words
        for (String word : input) {
            processWord(unorderedList, word);
        }
        return unorderedList;
    }

    private void processWord(List<String> unorderedList, String word) {
        if (word.contains("\n")) {
            String[] splitWord = word.split("\n");
            if (splitWord[0].contains(",")) {
                StringBuilder rightString = new StringBuilder();
                for (int i = 0; i < splitWord[0].length(); i++) {
                    char currentChar = splitWord[0].charAt(i);
                    if (currentChar != ',') {
                        rightString.append(currentChar);
                    }
                }
                unorderedList.add(rightString.toString());
            } else {
                unorderedList.add(splitWord[0]);
            }
        } else {
            unorderedList.add(word);
        }
    }

}
