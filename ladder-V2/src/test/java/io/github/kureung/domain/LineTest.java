package io.github.kureung.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LineTest {
    private static Stream<Arguments> 오른쪽_방향_또는_왼쪽_방향을_가진_포인트들이_연속으로_등장할_경우_예외가_발생한다() {
        return Stream.of(
                Arguments.of(new Directions(Direction.LEFT, Direction.BOTTOM)),
                Arguments.of(new Directions(Direction.RIGHT, Direction.BOTTOM))
        );
    }

    @MethodSource
    @ParameterizedTest
    void 오른쪽_방향_또는_왼쪽_방향을_가진_포인트들이_연속으로_등장할_경우_예외가_발생한다(final Directions directions) {
        final Point currentPoint = new Point(directions, 0);
        final Point nextPoint = new Point(directions, 0);
        assertThatThrownBy(() -> new Line(List.of(currentPoint, nextPoint)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("오른쪽 방향 또는 왼쪽 방향이 연속으로 있을 수 없습니다.");
    }
}
