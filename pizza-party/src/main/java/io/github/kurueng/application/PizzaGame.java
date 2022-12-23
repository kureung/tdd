package io.github.kurueng.application;

import io.github.kurueng.domain.People;
import io.github.kurueng.domain.Pizzas;

public record PizzaGame(Pizzas pizzas, People people) {
    public int piecesPerPerson() {
        return pizzas.piecesPerPerson(people);
    }

    public int leftoversPieces() {
        return pizzas.leftoversPieces(people);
    }
}
