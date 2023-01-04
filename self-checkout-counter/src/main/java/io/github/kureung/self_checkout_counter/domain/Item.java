package io.github.kureung.self_checkout_counter.domain;

public record Item(int price, int quantity) {
    public double subTotal() {
        return (double) price * quantity;
    }

    public double tax() {
        final double tax = 5.5;
        return (price * quantity) * tax / 100;
    }

    public double totalPrice() {
        return subTotal() - tax();
    }
}
