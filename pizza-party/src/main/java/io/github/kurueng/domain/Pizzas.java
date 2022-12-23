package io.github.kurueng.domain;

import java.util.List;

public record Pizzas(List<Pizza> values) {
    public int piecesPerPerson(final People eaters) {
        final int pieces = values.stream()
                .mapToInt(Pizza::pieces)
                .sum();
        return pieces / eaters.countPeople();
    }
}
