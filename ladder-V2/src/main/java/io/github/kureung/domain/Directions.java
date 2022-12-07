package io.github.kureung.domain;

import java.util.List;

public record Directions(List<Direction> values) {
    public Directions {
        boolean doesNotHaveBottom = values.stream()
                .allMatch(Direction::isNotBottom);

        if (doesNotHaveBottom) {
            throw new IllegalArgumentException("무조건 아래로 가는 방향을 가지고 있어야 합니다.");
        }
    }

    public boolean doesHaveOnlyBottom() {
        return values.stream()
                .allMatch(Direction::isBottom);
    }
}
