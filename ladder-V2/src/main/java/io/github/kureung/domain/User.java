package io.github.kureung.domain;

import io.github.kureung.domain.position.Position;

public record User(String name, Position position) {
    public User {
        if (5 < name.length()) {
            throw new IllegalArgumentException("이름은 5자를 초과할 수 없습니다.");
        }
    }

    public User(String name, int xCoordinate) {
        this(name, Position.firstPoint(xCoordinate));
    }

    public User movedUser(Point point) {
        Direction direction = point.directionToGo(position.y());
        return new User(name, position.movedPosition(direction));
    }

    public int xCoordinate() {
        return position.x();
    }
}
