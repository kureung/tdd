package io.github.kureung.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RectangleTest {
    @Test
    void 직사각형의_면적을_피트로_구할_수_있다() {
        final Rectangle rectangle = new Rectangle(15, 20);
        assertThat(rectangle.areaInFeet()).isEqualTo(300);
    }

    @ParameterizedTest
    @CsvSource({
            "0, 1",
            "1, -1",
    })
    void 직사각형의_가로길이_또는_세로길이가_양수가_아닐_경우_예외가_발생한다(final int widthInFeet, final int heightInFeet) {
        assertThatThrownBy(() -> new Rectangle(widthInFeet, heightInFeet))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("가로 길이와 세로 길이는 양수이어야 합니다.");
    }
}
