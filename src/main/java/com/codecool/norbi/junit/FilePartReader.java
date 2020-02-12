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
        while ((readFile = br.readLine()) != null) {
                returnValue.append(readFile).append("\n");
        }
        return returnValue.toString();
    }
    public String readLines() throws IOException {
        StringBuilder returnValue = new StringBuilder();
        int lineCounter = 1;
        String content = this.read();
        String[] input = content.split("\\r?\\n");
        for (String line : input) {
            if (lineCounter >= fromLine) {
                returnValue.append(line).append("\n");
            }
            if (lineCounter >= toLine) {
                break;
            }
            lineCounter++;
        }
        return returnValue.toString();
    }

    public String getFilePath() {
        return filePath;
    }

    public Integer getFromLine() {
        return fromLine;
    }

    public Integer getToLine() {
        return toLine;
    }
}
