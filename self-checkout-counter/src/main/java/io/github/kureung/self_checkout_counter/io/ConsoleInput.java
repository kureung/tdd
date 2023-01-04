package io.github.kureung.self_checkout_counter.io;

import io.github.kureung.self_checkout_counter.application.Input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleInput implements Input {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

    @Override
    public int price(final int itemNumber) throws IOException {
        System.out.println("Price of item " + itemNumber + ": ");
        return Integer.parseInt(READER.readLine());
    }

    @Override
    public int quantity(final int itemNumber) throws IOException {
        System.out.println("Quantity of item " + itemNumber + ": ");
        return Integer.parseInt(READER.readLine());
    }
}
