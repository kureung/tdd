package io.github.kureung.domain;

public record Rectangle(int widthInFeet, int heightInFeet) {
    public Rectangle {
        if (widthInFeet <= 0 || heightInFeet <= 0) {
            throw new IllegalArgumentException("가로 길이와 세로 길이는 양수이어야 합니다.");
        }
    }

    public int areaInFeet() {
        return widthInFeet * heightInFeet;
    }
}
