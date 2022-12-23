package io.github.kurueng.domain;

import java.util.List;

public record Pizzas(List<Pizza> values) {
    public int piecesPerPerson(final People eaters) {
        final int pieces = pieces();
        return pieces / eaters.countPeople();
    }

    public int leftoversPieces(final People eaters) {
        return pieces() % eaters.countPeople();
    }

    private int pieces() {
        return values.stream()
                .mapToInt(Pizza::pieces)
                .sum();
    }

    public int numberOfPiecesPerPizza() {
        return values.get(0).pieces();
    }
}
