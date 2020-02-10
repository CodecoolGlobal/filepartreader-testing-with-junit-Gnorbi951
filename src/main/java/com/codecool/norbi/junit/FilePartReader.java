package com.codecool.norbi.junit;

import java.io.*;

public class FilePartReader {
    private String filePath;

    public FilePartReader() {
    }

    public void setup(String filePath, Integer fromLine, Integer toLine) throws IllegalArgumentException{
        if (toLine < fromLine) {
           throw new IllegalArgumentException();
        }
        if (fromLine < 1) {
            throw new IllegalArgumentException();
        }
        this.filePath = filePath;
    }

    public String read() throws IOException {
        File file = new File(filePath);

        BufferedReader br = new BufferedReader(new FileReader(file));

        String readFile;
        StringBuilder returnValue = new StringBuilder();
        while ((readFile = br.readLine()) != null) {
            returnValue.append(readFile);
        }
        return returnValue.toString();
    }

    public static void main(String[] args) {

    }
}
