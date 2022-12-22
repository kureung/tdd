package io.github.kureung;

import io.github.kureung.application.App;
import io.github.kureung.domain.Rectangle;
import io.github.kureung.io.Input;
import io.github.kureung.io.Output;

import java.io.IOException;

public record Main() {
    public static void main(String[] args) throws IOException {
        final Input input = new Input();
        final Output output = new Output();
        final App app = new App(input, output);
        final Rectangle rectangle = app.rectangle();
        app.printRectangleArea(rectangle);
    }
}
