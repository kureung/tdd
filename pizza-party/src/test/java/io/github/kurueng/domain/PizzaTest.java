package io.github.kurueng.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PizzaTest {
    @ParameterizedTest
    @ValueSource(ints = {
            -1,
            0
    })
    void 피자_조각이_양수가_아닐_경우_예외가_발생한다(final int pieces) {
        assertThatThrownBy(() -> new Pizza(pieces))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("피자 조각 개수는 양수이어야 합니다.");
    }
}
