package io.github.kureung.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LinesTest {
    @Test
    void 부_생성자의_주_생성자_변환_테스트() {
        final Line firstLine = new Line(true);
        final Line secondLine = new Line(true);
        final List<Line> lines = List.of(firstLine, secondLine);
        assertThat(new Lines(firstLine, secondLine))
                .isEqualTo(new Lines(lines));
    }
}
