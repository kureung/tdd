package io.github.kureung.self_checkout_counter.application;

import io.github.kureung.self_checkout_counter.domain.Item;
import io.github.kureung.self_checkout_counter.domain.Items;

import java.io.IOException;
import java.util.List;

public record SelfCheckoutCounter(Input input, Output output) {
    public void count() throws IOException {
        final Items items = new Items(List.of(item(1), item(2), item(3)));
        output.printSubtotal(items);
        output.printTax(items);
        output.printTotalPrice(items);
    }

    private Item item(final int itemNumber) throws IOException {
        final int price = input.price(itemNumber);
        final int quantity = input.quantity(itemNumber);
        return new Item(price, quantity);
    }


}
