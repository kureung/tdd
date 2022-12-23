package io.github.kurueng.io;

import io.github.kurueng.application.PizzaGame;

public record Output() {
    public void print(final PizzaGame pizzaGame) {
        final String text = pizzaGame.peopleCount() + " people with " + pizzaGame.numberOfPizza() + " pizzas \n" +
                "Each person gets " + pizzaGame.piecesPerPerson() + " pieces of pizza. \n" +
                "There are " + pizzaGame.leftoversPieces() + " leftover pieces.";
        System.out.println(text);
    }
}
