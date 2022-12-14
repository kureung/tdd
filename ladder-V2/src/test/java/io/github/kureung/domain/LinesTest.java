package io.github.kureung.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LinesTest {
    @Test
    void 이동된_유저의_최종_위치를_조회할_수_있다() {
        final Line firstLine = new Line(Direction.RIGHT_AND_BOTTOM, Direction.LEFT_AND_BOTTOM);
        final Line secondLine = new Line(Direction.RIGHT_AND_BOTTOM, Direction.LEFT_AND_BOTTOM);
        final User user = new User("a", 0);

        final Lines lines = new Lines(List.of(firstLine, secondLine));

        assertThat(lines.movedXCoordinate(user)).isZero();
    }

    @Test
    void 행들의_각각의_행의_요소의_개수가_일치하지_않으면_예외가_발생한다() {
        final Line firstLine = new Line(Direction.RIGHT_AND_BOTTOM, Direction.LEFT_AND_BOTTOM);
        final Line secondLine = new Line(Direction.RIGHT_AND_BOTTOM, Direction.LEFT_AND_BOTTOM, Direction.BOTTOM);
        assertThatThrownBy(() -> new Lines(List.of(firstLine, secondLine)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("각각의 행의 요소 개수가 일치하지 않습니다.");
    }
}
