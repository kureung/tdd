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
}
