package io.github.kureung.domain.position;

import io.github.kureung.domain.Direction;

import java.util.Objects;

public class Position {
    private final int x;
    private final int y;

    Position(int x, int y) {
        if (x < 0) {
            throw new IllegalArgumentException("x 좌표는 음수일 수 없습니다.");
        }
        this.x = x;
        this.y = y;
    }

    public static Position firstPoint(int x) {
        return new Position(x, 0);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x && y == position.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public Position movedPosition(Direction direction) {
        return new Position(direction.movedXCoordinate(x), direction.movedYCoordinate(y));
    }

    public int x() {
        return x;
    }

    public int y() {
        return y;
    }
}
