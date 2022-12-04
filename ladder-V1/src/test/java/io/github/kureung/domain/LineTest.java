package io.github.kureung.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LineTest {
    @Test
    void 부_생성자의_주_생성자_변환_테스트() {
        final List<Boolean> doRoadsExist = List.of(true);
        assertThat(new Line(true)).isEqualTo(new Line(doRoadsExist));
    }

    @Test
    void 참이_여러개_일경우_예외가_발생한다() {
        final List<Boolean> doRoadsExist = List.of(true, true);
        assertThatThrownBy(() -> new Line(doRoadsExist))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("참이 연속해서 올 수 없습니다.");
    }

    @Test
    void 행의_요소의_개수를_구할_수_있다() {
        final Line line = new Line(true);
        assertThat(line.size()).isEqualTo(1);
    }

    @Test
    void 요소의_개수가_다른지_판별할_수_있다() {
        final Line line = new Line(true);
        assertAll(
                () -> assertTrue(line.isNotSameSize(2)),
                () -> assertFalse(line.isNotSameSize(1))
        );
    }
}
