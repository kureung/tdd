package io.github.kurueng.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public record Input() {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

    public int countPeople() throws IOException {
        System.out.println("How many people? ");
        return Integer.parseInt(READER.readLine());
    }

    public int countPizzas() throws IOException {
        System.out.println("How many pizzas do you have? ");
        return Integer.parseInt(READER.readLine());
    }

    public int piecesOfPizza() throws IOException {
        System.out.println("How many pieces are in a pizza? ");
        return Integer.parseInt(READER.readLine());
    }
}
