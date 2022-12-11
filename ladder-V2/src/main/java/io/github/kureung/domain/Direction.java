package io.github.kureung.domain;

public enum Direction {
    RIGHT_AND_BOTTOM(1, -1),
    LEFT_AND_BOTTOM(-1, -1),
    BOTTOM(0, -1),
    ;

    private final int xDistance;
    private final int yDistance;

    Direction(int xDistance, int yDistance) {
        this.xDistance = xDistance;
        this.yDistance = yDistance;
    }

    public int movedXCoordinate(int xCoordinate) {
        return xDistance + xCoordinate;
    }

    public int movedYCoordinate(int yCoordinate) {
        return yDistance + yCoordinate;
    }
}
