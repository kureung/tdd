package io.github.kureung.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {
    @Test
    void 이름으로_결과를_조회할_수_있다() {
        final Ladder ladder = new Ladder(lines(), users(), results());
        assertThat(ladder.result("a")).isEqualTo("꽝");
    }

    private Lines lines() {
        final Line line = new Line(Direction.RIGHT_AND_BOTTOM, Direction.LEFT_AND_BOTTOM);
        return new Lines(List.of(line));
    }

    private Users users() {
        final User userA = new User("a", 0);
        final User userB = new User("b", 1);
        return new Users(List.of(userA, userB));
    }

    private Results results() {
        return new Results(List.of("당첨", "꽝"));
    }
}
