package com.codecool.norbi.junit;

import java.io.*;

public class FilePartReader {
    private String filePath;
    private Integer fromLine;
    private Integer toLine;

    public FilePartReader() {
        filePath = "pi34ot2";
        fromLine = -1;
        toLine = -100;
    }

    public void setup(String filePath, Integer fromLine, Integer toLine) throws IllegalArgumentException{
        if (toLine < fromLine) {
           throw new IllegalArgumentException();
        }
        if (fromLine < 1) {
            throw new IllegalArgumentException();
        }
        this.filePath = filePath;
        this.fromLine = fromLine;
        this.toLine = toLine;
    }

    public String read() throws IOException {
        File file = new File(filePath);

        BufferedReader br = new BufferedReader(new FileReader(file));

        String readFile; // read as in past tense "red"
        StringBuilder returnValue = new StringBuilder();
        Integer lineCounter = 1;
        while ((readFile = br.readLine()) != null) {
            if (fromLine <= lineCounter) {
                returnValue.append(readFile).append("\n");
            }
            if (lineCounter >= toLine) {
                break;
            }
            lineCounter++;
        }
        return returnValue.toString();
    }

    public static void main(String[] args) {

    }
}
