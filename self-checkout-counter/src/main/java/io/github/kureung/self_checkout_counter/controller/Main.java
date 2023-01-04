package io.github.kureung.self_checkout_counter.controller;

import io.github.kureung.self_checkout_counter.application.SelfCheckoutCounter;
import io.github.kureung.self_checkout_counter.io.ConsoleInput;
import io.github.kureung.self_checkout_counter.io.ConsoleOutput;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        final SelfCheckoutCounter selfCheckoutCounter = new SelfCheckoutCounter(new ConsoleInput(), new ConsoleOutput());
        selfCheckoutCounter.count();
    }
}
