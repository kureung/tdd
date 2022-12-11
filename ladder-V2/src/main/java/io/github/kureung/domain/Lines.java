package io.github.kureung.domain;

import java.util.List;

public record Lines(List<Line> values) {
    public int movedUser(final User user) {
        User result = user;
        for (final Line value : values) {
            result = result.movedUser(value);
        }
        return result.xCoordinate();
    }
}
