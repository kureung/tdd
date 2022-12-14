package io.github.kureung.domain;

public enum Direction {
    RIGHT_AND_BOTTOM(1),
    LEFT_AND_BOTTOM(-1),
    BOTTOM(0),
    ;

    private final int xDistance;

    Direction(final int xDistance) {
        this.xDistance = xDistance;
    }

    public int movedXCoordinate(int xCoordinate) {
        return xDistance + xCoordinate;
    }

    public boolean isTheSame(final Direction target) {
        return this == target;
    }

    public boolean isNotTheSame(final Direction target) {
        return this != target;
    }
}
