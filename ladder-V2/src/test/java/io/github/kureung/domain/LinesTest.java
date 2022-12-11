package io.github.kureung.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LinesTest {
    @Test
    void 이동된_유저의_최종_위치를_조회할_수_있다() {
        final Line firstLine = new Line(Direction.RIGHT_AND_BOTTOM, Direction.LEFT_AND_BOTTOM);
        final Line secondLine = new Line(Direction.RIGHT_AND_BOTTOM, Direction.LEFT_AND_BOTTOM);
        final User user = new User("a", 0);

        final Lines lines = new Lines(List.of(firstLine, secondLine));

        assertThat(lines.movedUser(user)).isZero();
    }
}
