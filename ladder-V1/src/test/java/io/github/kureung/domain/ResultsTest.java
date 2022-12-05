package io.github.kureung.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ResultsTest {
    @Test
    void 부_생성자의_주_생성자로_변환_테스트() {
        final List<String> results = List.of("a");
        assertThat(new Results("a"))
                .isEqualTo(new Results(results));
    }

    @Test
    void 인덱스로_결과들을_조회할_수_있다() {
        Results results = new Results("a", "b");
        assertThat(results.value(0)).isEqualTo("a");
    }

    @Test
    void 결과들의_개수와_참여자들의_수가_같이_않으면_참이다() {
        Participants participants = new Participants("1");
        Results results = new Results("a", "b");
        assertTrue(results.isNotSameSize(participants));
    }
}
