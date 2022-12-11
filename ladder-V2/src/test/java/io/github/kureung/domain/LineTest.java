package io.github.kureung.domain;

import org.junit.jupiter.api.Test;

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
}
