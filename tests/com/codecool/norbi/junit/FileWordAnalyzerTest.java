package com.codecool.norbi.junit;

import static org.junit.jupiter.api.Assertions.*;

class FileWordAnalyzerTest {
    FilePartReader reader = new FilePartReader();
    FileWordAnalyzer analyzer = new FileWordAnalyzer(reader);

    @org.junit.jupiter.api.Test
    public void constructorGetsArgumentFromFilePartReader() {
        assertNotNull(analyzer);
    }
}