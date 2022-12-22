package io.github.kureung.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public record Input() {
    private static BufferedReader BUFFERED_READER = new BufferedReader(new InputStreamReader(System.in));

    public int length() throws IOException {
        System.out.print("What is hte length of hte room in feet?");
        return Integer.parseInt(BUFFERED_READER.readLine());
    }

    public int width() throws IOException {
        System.out.print("What is the width of the room in feet?");
        return Integer.parseInt(BUFFERED_READER.readLine());
    }
}
