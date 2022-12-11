package io.github.kureung.domain;

import java.util.Arrays;
import java.util.List;

public record Line(List<Direction> directions) {
    public Line {
        verifyFirstDirection(directions);
        verifyLastDirection(directions);
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

    private void verifyLastDirection(final List<Direction> directions) {
        final Direction lastDirection = directions.get(directions.size() - 1);
        if (lastDirection == Direction.RIGHT_AND_BOTTOM) {
            throw new IllegalArgumentException("마지막번째 방향이 오른쪽일 수 없습니다.");
        }
    }
}
