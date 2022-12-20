package io.github.kureung.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.params.provider.Arguments.of;

class DirectionTest {
    private static Stream<Arguments> x좌표를_알_수_있다() {
        return Stream.of(
                of(Direction.RIGHT_AND_BOTTOM, 2),
                of(Direction.LEFT_AND_BOTTOM, 0),
                of(Direction.BOTTOM, 1)
        );
    }

    @MethodSource
    @ParameterizedTest
    void x좌표를_알_수_있다(Direction direction, int result) {
        assertThat(direction.movedXCoordinate(1)).isEqualTo(result);
    }

    @Test
    void 같은_방향이면_참이다() {
        assertTrue(Direction.BOTTOM.isTheSame(Direction.BOTTOM));
    }

    @Test
    void 다른_방향이면_참이다() {
        assertTrue(Direction.BOTTOM.isNotTheSame(Direction.RIGHT_AND_BOTTOM));
    }
}
