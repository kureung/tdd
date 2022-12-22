package io.github.kureung.domain;

public record Rectangle(int widthInFeet, int heightInFeet) {
    public int areaInFeet() {
        return widthInFeet * heightInFeet;
    }
}
