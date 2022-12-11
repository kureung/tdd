package io.github.kureung.random;

import io.github.kureung.domain.Direction;

import java.util.ArrayList;
import java.util.List;
import java.util.random.RandomGenerator;

public record RandomDirectionsGenerator() {

    private static final RandomGenerator RANDOM = RandomGenerator.getDefault();

    public List<Direction> directions(final int size) {
        if (size < 0) {
            throw new IllegalArgumentException("사이즈는 음수일 수 없습니다.");
        }

        if (size == 1) {
            return List.of(Direction.BOTTOM);
        }

        final List<Direction> directions = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            if (i < size - 1) {
                if (RANDOM.nextBoolean()) {
                    directions.add(Direction.BOTTOM);
                    continue;
                }
                directions.add(Direction.RIGHT_AND_BOTTOM);
                directions.add(Direction.LEFT_AND_BOTTOM);
                i++;
                continue;
            }
            directions.add(Direction.BOTTOM);
        }
        return List.copyOf(directions);
    }


}
