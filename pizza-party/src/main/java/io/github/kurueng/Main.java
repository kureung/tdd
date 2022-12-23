package io.github.kurueng;

import io.github.kurueng.application.PizzaGame;
import io.github.kurueng.io.Input;
import io.github.kurueng.io.Output;

import java.io.IOException;

public record Main() {
    public static void main(String[] args) throws IOException {
        final Output output = new Output();

        final Input input = new Input();
        final int peopleCount = input.countPeople();
        final int pizzasCount = input.countPizzas();
        final int numberOfPiecesOfPizzas = input.piecesOfPizza();

        final PizzaGame pizzaGame = new PizzaGame(numberOfPiecesOfPizzas, pizzasCount, peopleCount);
        output.print(pizzaGame);
    }
}
