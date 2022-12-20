package io.github.kureung.domain;

public record Word(String value) {
    public int length() {
        return value.length();
    }
}
