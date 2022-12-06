package io.github.kureung.domain.position;

import io.github.kureung.domain.Direction;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.of;

class PositionTest {
    private static Stream<Arguments> 포지션은_방향에_따라_위치가_변한다() {
        return Stream.of(
                of(Direction.RIGHT, new Position(2, 0)),
                of(Direction.LEFT, new Position(0, 0)),
                of(Direction.BOTTOM, new Position(1, -1))
        );
    }

    @Test
    void 포지션은_첫_번째_지점의_y좌표는_0이다() {
        Position firstPoint = Position.firstPoint(1);
        assertThat(firstPoint).isEqualTo(new Position(1, 0));
    }

    @MethodSource
    @ParameterizedTest
    void 포지션은_방향에_따라_위치가_변한다(Direction direction, Position result) {
        Position position = Position.firstPoint(1);
        assertThat(position.movedPosition(direction)).isEqualTo(result);
    }

    @Test
    void 포지션의_x좌표가_음수일_경우_예외가_발생한다() {
        Position position = Position.firstPoint(0);
        assertThatThrownBy(() -> position.movedPosition(Direction.LEFT))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("x 좌표는 음수일 수 없습니다.");
    }
}
