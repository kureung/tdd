package io.github.kureung.domain.position;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {
    @Test
    void 포지션은_첫_번째_지점의_y좌표는_0이다() {
        Position firstPoint = Position.firstPoint(1);
        assertThat(firstPoint).isEqualTo(new Position(1, 0));
    }
}
