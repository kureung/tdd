package io.github.kureung.io;

public record Output() {
    public void printArea(final int areaInFeet, final double areaInMeter) {
        final String text = "The area is \n" +
                areaInFeet + " square feet \n" +
                areaInMeter + " square meters";
        System.out.println(text);
    }
}
