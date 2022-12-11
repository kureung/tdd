package io.github.kureung.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderTest {
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

    @Test
    void 이름으로_결과를_조회할_수_있다() {
        final Ladder ladder = new Ladder(lines(), users(), results());
        assertThat(ladder.result("a")).isEqualTo("꽝");
    }

    @Test
    void 결과의_개수와_유저의수가_같지않으면_예외가_발생한다() {
        final Lines lines = lines();
        final Users users = users();
        final Results results = new Results(List.of("당첨"));

        assertThatThrownBy(() -> new Ladder(lines, users, results))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("유저 수와 결과의 개수가 일치하지 않습니다.");
    }

    @Test
    void 각_행의_방향_개수와_유저의수가_같지않으면_예외가_발생한다() {
        final Lines lines = new Lines(List.of(new Line(Direction.BOTTOM)));
        final Users users = users();
        final Results results = results();

        assertThatThrownBy(() -> new Ladder(lines, users, results))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("유저 수와 각 행의 방향 개수가 일치하지 않습니다.");
    }
}
