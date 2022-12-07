package io.github.kureung.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PointTest {
    @Test
    void y값이_양수일_경우_예외가_발생한다() {
        final Directions directions = new Directions(List.of(Direction.BOTTOM));
        assertThatThrownBy(() -> new Point(directions, 1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("y값은 음수이거나 0이어야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {
            -1,
            0
    })
    void y값이_0이거나_음수일_경우_에외가_발생하지_않는다(int yCoordinate) {
        final Directions directions = new Directions(List.of(Direction.BOTTOM));
        assertThatCode(() -> new Point(directions, yCoordinate))
                .doesNotThrowAnyException();
    }
}
