package com.codecool.norbi.junit;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileWordAnalyzer {
    private FilePartReader reader;

    public FileWordAnalyzer(FilePartReader reader) {
        this.reader = reader;
    }

    public List<String> getWordsOrderedAlphabetically() throws IOException {
        String[] input = reader.readLines().split(" ");
        List<String> unorderedList = new ArrayList<>(Arrays.asList(input));
        return unorderedList;
    }

}
