package io.github.kureung.domain;

public enum Direction {
    RIGHT(1, 0),
    LEFT(-1, 0),
    BOTTOM(0, -1),
    ;

    private final int xDistance;
    private final int yDistance;

    Direction(int xDistance, int yDistance) {
        this.xDistance = xDistance;
        this.yDistance = yDistance;
    }

    public int xCoordinate(int x) {
        return xDistance + x;
    }

    public int yCoordinate(int y) {
        return yDistance + y;
    }
}
