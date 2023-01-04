package io.github.kureung.self_checkout_counter.domain;

public record Item(int price, int quantity) {
    public double subTotal() {
        return (double) price * quantity;
    }
}
