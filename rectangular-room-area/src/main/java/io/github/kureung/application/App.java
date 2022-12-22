package io.github.kureung.application;

import io.github.kureung.domain.Rectangle;
import io.github.kureung.io.Input;
import io.github.kureung.io.Output;

import java.io.IOException;

public record App(Input input, Output output) {
    public Rectangle rectangle() throws IOException {
        return new Rectangle(input.width(), input.length());
    }
}
