package io.github.kureung.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ResultsTest {
    @Test
    void 인덱스로_결과를_조회할_수_있다() {
        final Results results = new Results(List.of("당첨", "꽝"));
        assertThat(results.result(0)).isEqualTo("당첨");
    }
}
