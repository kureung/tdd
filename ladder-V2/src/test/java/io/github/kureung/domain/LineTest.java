package io.github.kureung.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LineTest {
    @Test
    void 행의_첫번째_방향이_왼쪽일_경우_예외가_발생한다() {
        assertThatThrownBy(() -> new Line(Direction.LEFT_AND_BOTTOM, Direction.BOTTOM))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("첫번째 방향이 왼쪽일 수 없습니다.");
    }

    @Test
    void 행의_마지막번째_방향이_오른쪽일_경우_예외가_발생한다() {
        assertThatThrownBy(() -> new Line(Direction.BOTTOM, Direction.RIGHT_AND_BOTTOM))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("마지막번째 방향이 오른쪽일 수 없습니다.");
    }

    @Test
    void 오른쪽_방향_다음에는_왼쪽_방향이_나오지_않으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Line(Direction.RIGHT_AND_BOTTOM, Direction.BOTTOM))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("오른쪽 방향 다음에는 왼쪽 방향이 와야합니다.");
    }

    @Test
    void 왼쪽_방향이_연속으로_존재할_경우_예외가_발생한다() {
        assertThatThrownBy(() -> new Line(Direction.BOTTOM, Direction.LEFT_AND_BOTTOM, Direction.LEFT_AND_BOTTOM))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("왼쪽 방향이 연속으로 올 수 없습니다.");
    }

    @Test
    void 포지션의_x좌표값에_존재하는_방향에_의해_움직일_수_있다() {
        final Position position = new Position(0);
        final Line line = new Line(Direction.RIGHT_AND_BOTTOM, Direction.LEFT_AND_BOTTOM);
        assertThat(line.movedPosition(position)).isEqualTo(new Position(1));
    }

    @Test
    void 포지션의_x좌표가_행의_요소보다_많을_경우_예외가_발생한다() {
        final Position position = new Position(2);
        final Line line = new Line(Direction.RIGHT_AND_BOTTOM, Direction.LEFT_AND_BOTTOM);
        assertThatThrownBy(() -> line.movedPosition(position))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("포지션의 x 좌표가 유효하지 않습니다.");
    }
}
