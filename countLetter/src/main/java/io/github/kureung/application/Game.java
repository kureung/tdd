package io.github.kureung.application;

import io.github.kureung.domain.Word;
import io.github.kureung.io.Input;
import io.github.kureung.io.Output;

import java.io.IOException;

public record Game(Input input, Output output) {
    public Word word() throws IOException {
        return new Word(input.enterWord());
    }

    public void print(final Word word) {
        output.printWordAndLength(word);
    }
}
