package io.github.kureung.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderTest {
    @Test
    void 참여자들의_수와_결과들의_개수가_다르면_에외가_발생한다() {
        final Lines lines = new Lines(new Line(true));
        final Participants participants = new Participants("a", "b");
        final Results results = new Results("당첨");
        assertThatThrownBy(() -> new Ladder(participants, lines, results))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("참여자들의 수와 결과들의 개수는 같아야합니다.");
    }

    @Test
    void 사다리_결과를_알_수_있다() {
        final Lines lines = new Lines(new Line(true));
        final Participants participants = new Participants("1", "2");
        final Results results = new Results("1000", "2000");
        final Ladder ladder = new Ladder(participants, lines, results);
        assertThat(ladder.result("1")).isEqualTo("2000");
    }
}
