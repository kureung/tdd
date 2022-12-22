package io.github.kureung.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RectangleTest {
    @Test
    void 직사각형의_면적을_피트로_구할_수_있다() {
        final Rectangle rectangle = new Rectangle(15, 20);
        assertThat(rectangle.areaInFeet()).isEqualTo(300);
    }
}
