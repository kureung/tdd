package io.github.kureung.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ResultsTest {
    @Test
    void 인덱스로_결과를_조회할_수_있다() {
        final Results results = new Results(List.of("당첨", "꽝"));
        assertThat(results.result(0)).isEqualTo("당첨");
    }

    @Test
    void 인덱스가_결과들의_사이즈보다_같거나_클_경우_예외가_발생한다() {
        final Results results = new Results(List.of("당첨"));
        assertThatThrownBy(() -> results.result(1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("인덱스가 올바르지 않습니다.");
    }
}
