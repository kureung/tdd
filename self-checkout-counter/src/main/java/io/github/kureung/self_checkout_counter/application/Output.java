package io.github.kureung.self_checkout_counter.application;

import io.github.kureung.self_checkout_counter.domain.Items;

public interface Output {
    void printSubtotal(final Items items);
    void printTax(final Items items);
    void printTotalPrice(final Items items);
}
