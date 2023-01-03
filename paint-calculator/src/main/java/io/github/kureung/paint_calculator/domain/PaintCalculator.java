package io.github.kureung.paint_calculator.domain;

public record PaintCalculator(int squareMeterArea) {
    public int amountOfPaintNeeded() {
        final double amountOfPaintRequiredPerSquareMeter = 9.0;
        return (int) Math.ceil(squareMeterArea / amountOfPaintRequiredPerSquareMeter);
    }
}
