package io.github.kureung.domain;

public record Euros(int value) {
    public double exchangedDollars(final double rate) {
        return (value * rate) / 100;
    }
}

