package io.github.kureung.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.params.provider.Arguments.of;
import static org.junit.jupiter.params.provider.EnumSource.Mode.EXCLUDE;

class DirectionTest {
    private static Stream<Arguments> x좌표를_알_수_있다() {
        return Stream.of(
                of(Direction.RIGHT_AND_BOTTOM, 2),
                of(Direction.LEFT_AND_BOTTOM, 0),
                of(Direction.BOTTOM, 1)
        );
    }

    private static Stream<Arguments> y좌표를_알_수_있다() {
        return Stream.of(
                of(Direction.RIGHT_AND_BOTTOM, 0),
                of(Direction.LEFT_AND_BOTTOM, 0),
                of(Direction.BOTTOM, 0)
        );
    }

    @MethodSource
    @ParameterizedTest
    void x좌표를_알_수_있다(Direction direction, int result) {
        assertThat(direction.movedXCoordinate(1)).isEqualTo(result);
    }

    @MethodSource
    @ParameterizedTest
    void y좌표를_알_수_있다(final Direction direction, final int result) {
        assertThat(direction.movedYCoordinate(1)).isEqualTo(result);
    }

    @ParameterizedTest
    @EnumSource(mode = EXCLUDE, names = "BOTTOM", value = Direction.class)
    void 아래로_가는_방향이_아닐_경우_참이다(Direction direction) {
        assertTrue(direction.isNotBottom());
    }

    @Test
    void 아래로_가는_방향일_경우_참이다() {
        assertTrue(Direction.BOTTOM.isBottom());
    }
}
