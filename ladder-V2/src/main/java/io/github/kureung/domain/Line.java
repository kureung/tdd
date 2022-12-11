package io.github.kureung.domain;

import java.util.Arrays;
import java.util.List;

public record Line(List<Direction> directions) {
    public Line {
        verifyFirstDirection(directions);
    }

    public Line(final Direction... directions) {
        this(convertedCollection(directions));
    }

    private static List<Direction> convertedCollection(final Direction... directions) {
        return Arrays.stream(directions)
                .toList();
    }

    private void verifyFirstDirection(final List<Direction> directions) {
        final Direction firstDirection = directions.get(0);
        if (firstDirection == Direction.LEFT_AND_BOTTOM) {
            throw new IllegalArgumentException("첫번째 방향이 왼쪽일 수 없습니다.");
        }
    }
}
