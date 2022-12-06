package io.github.kureung.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.of;

class DirectionTest {
    private static Stream<Arguments> x좌표를_알_수_있다() {
        return Stream.of(
                of(Direction.RIGHT, 2),
                of(Direction.LEFT, 0),
                of(Direction.BOTTOM, 1)
        );
    }

    private static Stream<Arguments> y좌표를_알_수_있다() {
        return Stream.of(
                of(Direction.RIGHT, 1),
                of(Direction.LEFT, 1),
                of(Direction.BOTTOM, 0)
        );
    }

    @MethodSource
    @ParameterizedTest
    void x좌표를_알_수_있다(Direction direction, int result) {
        assertThat(direction.xCoordinate(1)).isEqualTo(result);
    }

    @MethodSource
    @ParameterizedTest
    void y좌표를_알_수_있다(Direction direction, int result) {
        assertThat(direction.yCoordinate(1)).isEqualTo(result);
    }
}
