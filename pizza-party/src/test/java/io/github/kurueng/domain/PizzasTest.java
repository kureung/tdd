package io.github.kurueng.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PizzasTest {
    @Test
    void 피자들_생성하기() {
        final Pizzas pizzas = Pizzas.initBy(4, 2);
        assertThat(pizzas)
                .isEqualTo(new Pizzas(List.of(new Pizza(4), new Pizza(4))));
    }

    @Test
    void 한_사람당_피자를_몇_조각_먹을_수_있는지_알_수_있다() {
        final People eaters = new People(2);
        final Pizzas pizzas = Pizzas.initBy(8, 1);
        assertThat(pizzas.piecesPerPerson(eaters)).isEqualTo(4);
    }

    @Test
    void 피자를_나눈_후_남은_조각을_구할_수_있다() {
        final People eaters = new People(3);
        final Pizzas pizzas = Pizzas.initBy(4, 1);
        assertThat(pizzas.leftoversPieces(eaters)).isEqualTo(1);
    }

    @Test
    void 한_피자당_피자_조각_개수() {
        final Pizzas pizzas = Pizzas.initBy(4, 1);
        assertThat(pizzas.numberOfPiecesPerPizza()).isEqualTo(4);
    }

    @Test
    void 피자_개수_구하기() {
        final Pizzas pizzas = Pizzas.initBy(4, 1);
        assertThat(pizzas.numberOfPizza()).isEqualTo(1);
    }
}
