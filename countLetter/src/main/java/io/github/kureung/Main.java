package io.github.kureung;

import io.github.kureung.application.Game;
import io.github.kureung.domain.Word;
import io.github.kureung.io.Input;
import io.github.kureung.io.Output;

import java.io.IOException;

public record Main() {
    public static void main(String[] args) throws IOException {
        final Game game = new Game(new Input(), new Output());
        final Word word = game.word();
        game.print(word);
    }
}
