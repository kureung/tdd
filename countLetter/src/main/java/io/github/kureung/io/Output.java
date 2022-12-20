package io.github.kureung.io;

import io.github.kureung.domain.Word;

public record Output() {
    public void printWordAndLength(final Word word) {
        final String value = word.value();
        System.out.println(value);
        System.out.println(value + " has " + word.length() + "characters.");
    }
}
