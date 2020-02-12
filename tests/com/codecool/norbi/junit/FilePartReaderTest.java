package com.codecool.norbi.junit;

import org.junit.Test;


import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class FilePartReaderTest {
    FilePartReader reader = new FilePartReader();

    @org.junit.jupiter.api.Test
    public void ConstructorIsNotEmpty() {
        assertNotNull(reader.getToLine());
        assertNotNull(reader.getFromLine());
        assertNotNull(reader.getFilePath());
    }

    @org.junit.jupiter.api.Test
    public void invalidLinesThrowException() {
        assertThrows(IllegalArgumentException.class, () ->
            reader.setup("anything",3, 1));
        assertThrows(IllegalArgumentException.class, () ->
            reader.setup("anything",-1, 1));

    }

    @org.junit.jupiter.api.Test
    public void readReturnsString() throws IOException {
        reader.setup("C:\\Codecool\\OOP\\5th_SI\\filepartreader-testing-with-junit-Gnorbi951\\test.txt", 1,3);
        assertEquals(String.class, reader.read().getClass());
    }

    @org.junit.jupiter.api.Test
    public void readLinesReturnsCorrectLines() throws IOException {
        reader.setup("C:\\Codecool\\OOP\\5th_SI\\filepartreader-testing-with-junit-Gnorbi951\\test.txt", 1,3);
        String result = reader.readLines();
        assertEquals(result, "According to all known laws\nof aviation,\nthere is no way a bee abba\n");
        reader.setup("C:\\Codecool\\OOP\\5th_SI\\filepartreader-testing-with-junit-Gnorbi951\\test.txt", 1,1);
        result = reader.readLines();
        assertEquals(result, "According to all known laws\n");
    }
}