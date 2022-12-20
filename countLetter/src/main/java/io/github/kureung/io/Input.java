package io.github.kureung.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public record Input() {
    private static final BufferedReader BUFFERED_READER = new BufferedReader(new InputStreamReader(System.in));

    public String enterWord() throws IOException {
        String word = "";
        while(isNullOrEmpty(word)) {
            System.out.print("What is the input string? ");
            word = BUFFERED_READER.readLine();
        }
        return word;
    }

    private boolean isNullOrEmpty(final String value) {
        return value == null || value.length() == 0;
    }
}
