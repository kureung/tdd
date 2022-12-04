package io.github.kureung.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {
    @Test
    void 부_생성자의_주_생성자_변환_테스트() {
        final List<Boolean> doRoadsExist = List.of(true);
        assertThat(new Line(true)).isEqualTo(new Line(doRoadsExist));
    }
}
