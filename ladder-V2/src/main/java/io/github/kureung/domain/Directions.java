package io.github.kureung.domain;

import java.util.Arrays;
import java.util.List;

public record Directions(List<Direction> values) {
    public Directions {
        verifyMustHaveBottom(values);
        verifySize(values);
    }

    public Directions(final Direction... values) {
        this(collect(values));
    }

    private static List<Direction> collect(final Direction... values) {
        return Arrays.stream(values).toList();
    }

    private void verifyMustHaveBottom(List<Direction> values) {
        boolean doesNotHaveBottom = values.stream()
                .allMatch(Direction::isNotBottom);

        if (doesNotHaveBottom) {
            throw new IllegalArgumentException("무조건 아래로 가는 방향을 가지고 있어야 합니다.");
        }
    }

    private void verifySize(List<Direction> values) {
        final int DirectionCount = values.size();
        if (2 < DirectionCount) {
            throw new IllegalArgumentException("방향의 개수는 1개 또는 2개 이어야합니다.");
        }
    }

    public boolean doesHaveOnlyBottom() {
        return values.stream()
                .allMatch(Direction::isBottom);
    }

    public Direction directionNotBottom() {
        return values.stream()
                .filter(Direction::isNotBottom)
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("아래로 가는 방향만 존재합니다."));
    }

    public Direction bottom() {
        return values.stream()
                .filter(Direction::isBottom)
                .findFirst()
                .orElseThrow(IllegalStateException::new);
    }

    public boolean isIncludeDirection(final Direction target) {
        return values.contains(target);
    }

    public boolean isNotIncludeDirection(final Direction target) {
        return !values.contains(target);
    }
}
