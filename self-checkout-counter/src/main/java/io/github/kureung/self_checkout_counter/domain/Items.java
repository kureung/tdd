package io.github.kureung.self_checkout_counter.domain;

import java.util.List;

public record Items(List<Item> values) {
    public double subtotal() {
        return values.stream()
                .mapToDouble(Item::subTotal)
                .sum();
    }

    public double tax() {
        return values.stream()
                .mapToDouble(Item::tax)
                .sum();
    }
}
