package io.github.kureung.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.of;

class LineTest {
    private static Stream<Arguments> 오른쪽_방향_또는_왼쪽_방향을_가진_포인트들이_연속으로_등장할_경우_예외가_발생한다() {
        return Stream.of(
                of(Direction.LEFT, Direction.BOTTOM),
                of(Direction.RIGHT, Direction.BOTTOM)
        );
    }

    @MethodSource
    @ParameterizedTest
    void 오른쪽_방향_또는_왼쪽_방향을_가진_포인트들이_연속으로_등장할_경우_예외가_발생한다(final Direction... directions) {
        final Point firstPoint = point(Direction.BOTTOM);
        final Point lastPoint = point(Direction.BOTTOM);
        final Point targetPoint = point(directions);
        final Point nextPoint = point(directions);

        assertThatThrownBy(() -> new Line(List.of(firstPoint, targetPoint, nextPoint, lastPoint)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("오른쪽 방향 또는 왼쪽 방향이 연속으로 있을 수 없습니다.");
    }

    private Point point(final Direction... directions) {
        return new Point(new Directions(directions), 0);
    }

    @Test
    void 오른쪽_방향을_가진_지점_다음에는_왼쪽_방향을_가진_지점이_오지_않으면_예외가_발생한다() {
        final Directions rightAndBottom = new Directions(Direction.RIGHT, Direction.BOTTOM);
        final Directions onlyBottom = new Directions(Direction.BOTTOM);

        final Point currentPoint = new Point(rightAndBottom, 0);
        final Point nextPoint = new Point(onlyBottom, 0);

        assertThatThrownBy(() -> new Line(currentPoint, nextPoint))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("오른쪽 방향을 가진 지점 다음에는 왼쪽 방향을 가진 지점이 와야합니다.");
    }

    @Test
    void 오른쪽_방향을_가진_지점_다음에는_왼쪽_방향을_가진_지점이_오면_예외가_발생하지_않는다() {
        final Directions rightAndBottom = new Directions(Direction.RIGHT, Direction.BOTTOM);
        final Directions leftAndBottom = new Directions(Direction.LEFT, Direction.BOTTOM);

        final Point currentPoint = new Point(rightAndBottom, 0);
        final Point nextPoint = new Point(leftAndBottom, 0);

        assertThatCode(() -> new Line(currentPoint, nextPoint))
                .doesNotThrowAnyException();
    }
}