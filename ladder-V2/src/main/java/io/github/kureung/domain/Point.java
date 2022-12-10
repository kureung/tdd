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

    public boolean doesntHaveOnlyBottom() {
        return !directions.doesHaveOnlyBottom();
    }

    public boolean isSameDirections(final Point point) {
        return this.directions.equals(point.directions);
    }

    public boolean isIncludeDirection(final Direction target) {
        return directions.isIncludeDirection(target);
    }

    public boolean isNotIncludeDirection(final Direction target) {
        return directions.isNotIncludeDirection(target);
    }
}