package io.github.kureung.self_checkout_counter.io;

public class Output {
    public void printSubtotal(final double subTotal) {
        System.out.println("Subtotal: $" + subTotal);
    }

    public void printTax(final double tax) {
        System.out.println("Tax: $" + tax);
    }

    public void printTotalPrice(final double totalPrice) {
        System.out.println("Total: $" + totalPrice);
    }
}
