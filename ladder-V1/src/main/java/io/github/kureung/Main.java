package io.github.kureung;

import io.github.kureung.view.ConsoleInputView;
import io.github.kureung.view.ConsoleOutputView;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        final ConsoleInputView consoleInputView = new ConsoleInputView();
        final ConsoleOutputView consoleOutputView = new ConsoleOutputView();
        final Game game = new Game(consoleInputView, consoleOutputView);
        game.run();
    }
}
