package io.github.kurueng.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
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

    @Test
    void 피자_조각이_짝수가_아닐_경우_예외가_발생한다() {
        assertThatThrownBy(() -> new Pizza(1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("피자 조각 개수는 짝수이어야 합니다.");
    }

    @Test
    void 한_사람당_피자를_몇_조각_먹을_수_있는지_알_수_있다() {
        final People pizzaEaters = new People(2);
        final Pizza pizza = new Pizza(8);
        assertThat(pizza.piecesPerPerson(pizzaEaters)).isEqualTo(4);
    }
}
