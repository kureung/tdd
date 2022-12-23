package io.github.kurueng.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class Pizzas {

    private final List<Pizza> values;
    Pizzas(final List<Pizza> values) {
        this.values = values;
    }

    public static Pizzas initBy(final int numberOfPiecePerPizza, final int numberOfPizza) {
        final List<Pizza> pizzas = IntStream.range(0, numberOfPizza)
                .mapToObj(pizza -> new Pizza(numberOfPiecePerPizza))
                .toList();
        return new Pizzas(pizzas);
    }

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

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Pizzas pizzas = (Pizzas) o;
        return Objects.equals(values, pizzas.values);
    }

    @Override
    public int hashCode() {
        return Objects.hash(values);
    }
}
