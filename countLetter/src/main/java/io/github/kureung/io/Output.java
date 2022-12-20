package io.github.kureung.io;

import io.github.kureung.domain.Word;

public record Output() {
    public void printWordAndLength(final Word word) {
        System.out.println(word.value() + " has " + word.length() + " characters.");
    }
}
