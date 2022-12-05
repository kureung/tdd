package io.github.kureung.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LinesTest {
    @Test
    void 부_생성자의_주_생성자_변환_테스트() {
        final Line firstLine = new Line(true);
        final Line secondLine = new Line(true);
        final List<Line> lines = List.of(firstLine, secondLine);
        assertThat(new Lines(firstLine, secondLine))
                .isEqualTo(new Lines(lines));
    }

    @Test
    void 각각의_행들의_요소의_개수가_모두_같지_않으면_예외가_발생한다() {
        final Line firstLine = new Line(true);
        final Line secondLine = new Line(true, false);
        assertThatThrownBy(() -> new Lines(firstLine, secondLine))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("각각의 행들의 요소의 개수가 모두 같아야합니다.");
    }

    @Test
    void 참여자들_수가_행들의_개수보다_1개_더_많지_않으면_참이다() {
        final Line line = new Line(true);
        final Lines lines = new Lines(line);
        final Participants participants = new Participants("1");
        assertTrue(lines.isNotSizeMoreThanOne(participants));
    }

    @Test
    void 길을_건넌_결과를_알_수_있다() {
        final Line firstLine = new Line(true);
        final Line secondLine = new Line(false);
        final Lines lines = new Lines(firstLine, secondLine);
        final Participants participants = new Participants("a", "b");
        assertThat(lines.participantsCrossingTheRoad(participants))
                .isEqualTo(new Participants("b", "a"));
    }
}
