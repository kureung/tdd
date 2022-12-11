package io.github.kureung.domain;


import java.util.Objects;

public record User(String name, Position position) {
    public User {
        if (5 < name.length()) {
            throw new IllegalArgumentException("이름은 5자를 초과할 수 없습니다.");
        }
    }

    public User(final String name, final int xCoordinate) {
        this(name, new Position(xCoordinate));
    }

    public int xCoordinate() {
        return position.xCoordinate();
    }

    public User movedUser(final Line line) {
        return new User(name, line.movedPosition(position));
    }

    public boolean isTheSameName(final String name) {
        return Objects.equals(this.name, name);
    }
}
