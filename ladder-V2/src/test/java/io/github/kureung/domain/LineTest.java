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
                of(List.of(Direction.LEFT, Direction.BOTTOM)),
                of(List.of(Direction.RIGHT_AND_BOTTOM, Direction.BOTTOM))
        );
    }

    private Point point(final Direction... directions) {
        return new Point(new Directions(directions), 0);
    }

    private Point point(final List<Direction> directions) {
        return new Point(new Directions(directions), 0);
    }

    @MethodSource
    @ParameterizedTest
    void 오른쪽_방향_또는_왼쪽_방향을_가진_포인트들이_연속으로_등장할_경우_예외가_발생한다(final List<Direction> directions) {
        final Point firstPoint = point(Direction.BOTTOM);
        final Point targetPoint = point(directions);
        final Point nextPoint = point(directions);
        final Point lastPoint = point(Direction.BOTTOM);

        assertThatThrownBy(() -> new Line(firstPoint, targetPoint, nextPoint, lastPoint))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("오른쪽 방향 또는 왼쪽 방향이 연속으로 있을 수 없습니다.");
    }

    @Test
    void 오른쪽_방향을_가진_지점_다음에는_왼쪽_방향을_가진_지점이_오지_않으면_예외가_발생한다() {
        final Point firstPoint = point(Direction.BOTTOM);
        final Point targetPoint = point(Direction.RIGHT_AND_BOTTOM, Direction.BOTTOM);
        final Point nextPoint = point(Direction.BOTTOM);
        final Point lastPoint = point(Direction.BOTTOM);

        assertThatThrownBy(() -> new Line(firstPoint, targetPoint, nextPoint, lastPoint))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("오른쪽 방향을 가진 지점 다음에는 왼쪽 방향을 가진 지점이 와야합니다.");
    }

    @Test
    void 오른쪽_방향을_가진_지점_다음에는_왼쪽_방향을_가진_지점이_오면_예외가_발생하지_않는다() {
        final Directions rightAndBottom = new Directions(Direction.RIGHT_AND_BOTTOM, Direction.BOTTOM);
        final Directions leftAndBottom = new Directions(Direction.LEFT, Direction.BOTTOM);

        final Point currentPoint = new Point(rightAndBottom, 0);
        final Point nextPoint = new Point(leftAndBottom, 0);

        assertThatCode(() -> new Line(currentPoint, nextPoint))
                .doesNotThrowAnyException();
    }

    @Test
    void 행의_첫번째_요소에_왼쪽_방향을_가진_지점이_올_경우_예외가_발생한다() {
        final Directions leftAndBottom = new Directions(Direction.LEFT, Direction.BOTTOM);
        final Point firstPoint = new Point(leftAndBottom, 0);

        assertThatThrownBy(() -> new Line(firstPoint))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("행의 첫번째 요소에는 왼쪽 방향을 가진 지점이 올 수 없습니다.");
    }

    @Test
    void 행의_마지막_요소에_오른쪽_방향을_가진_지점이_올_경우_예외가_발생한다() {
        final Directions rightAndBottom = new Directions(Direction.RIGHT_AND_BOTTOM, Direction.BOTTOM);
        final Point lastPoint = new Point(rightAndBottom, 0);

        assertThatThrownBy(() -> new Line(lastPoint))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("행의 마지막 요소에는 오른쪽 방향을 가진 지점이 올 수 없습니다.");
    }
}
