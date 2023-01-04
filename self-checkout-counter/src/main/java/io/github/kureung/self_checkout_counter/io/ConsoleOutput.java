package io.github.kureung.self_checkout_counter.io;

import io.github.kureung.self_checkout_counter.application.Output;
import io.github.kureung.self_checkout_counter.domain.Items;

public class ConsoleOutput implements Output {
    @Override
    public void printSubtotal(final Items items) {
        System.out.println("Subtotal: $" + items.subtotal());
    }

    @Override
    public void printTax(final Items items) {
        System.out.println("Tax: $" + items.tax());
    }

    @Override
    public void printTotalPrice(final Items items) {
        System.out.println("Total: $" + items.totalPrice());
    }
}
