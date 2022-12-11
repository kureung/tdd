package io.github.kureung.domain;

public record Position(int xCoordinate) {
    public Position {
        if (xCoordinate < 0) {
            throw new IllegalArgumentException("x 좌표는 음수일 수 없습니다.");
        }
    }

    public Position movedPosition(final Direction direction) {
        return new Position(direction.movedXCoordinate(xCoordinate));
    }
}
