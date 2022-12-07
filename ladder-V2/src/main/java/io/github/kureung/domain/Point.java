package io.github.kureung.domain;

public record Point(Directions directions, int yCoordinate) {
    public Point {
        if (0 < yCoordinate) {
            throw new IllegalArgumentException("y값은 음수이거나 0이어야 합니다.");
        }
    }

    public Direction directionToGo(int yCoordinate) {
        return this.yCoordinate == yCoordinate
                ? directions.bottom()
                : directions.directionNotBottom();
    }
}
