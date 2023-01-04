package io.github.kureung.self_checkout_counter.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

    public int price(final int itemNumber) throws IOException {
        System.out.println("Price of item " + itemNumber + ": ");
        return Integer.parseInt(READER.readLine());
    }

    public int quantity(final int itemNumber) throws IOException {
        System.out.println("Quantity of item " + itemNumber + ": ");
        return Integer.parseInt(READER.readLine());
    }
}
