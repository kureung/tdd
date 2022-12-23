package io.github.kurueng.application;

import io.github.kurueng.domain.People;
import io.github.kurueng.domain.Pizzas;

public record PizzaGame(Pizzas pizzas, People people) {
    public PizzaGame(final int numberOfPiecePerPizza, final int numberOfPizza, final int peopleCount) {
        this(Pizzas.initBy(numberOfPiecePerPizza, numberOfPizza), new People(peopleCount));
    }

    public int piecesPerPerson() {
        return pizzas.piecesPerPerson(people);
    }

    public int leftoversPieces() {
        return pizzas.leftoversPieces(people);
    }

    public int numberOfPizza() {
        return pizzas.numberOfPizza();
    }

    public int numberOfPiecesPerPizza() {
        return pizzas.numberOfPiecesPerPizza();
    }
}
