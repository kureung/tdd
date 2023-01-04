package io.github.kureung.self_checkout_counter.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ItemTest {
    @Test
    void 세금이_적용되기전_상품의_가격을_알_수_있다() {
        final int price = 25;
        final int quantity = 2;
        final Item item = new Item(price, quantity);
        assertThat(item.subTotal()).isEqualTo(50.00);
    }

    @Test
    void 상품의_세금을_알_수_있다() {
        final int price = 25;
        final int quantity = 2;
        final Item item = new Item(price, quantity);
        Assertions.assertThat(item.tax()).isEqualTo(2.75);
    }
}
