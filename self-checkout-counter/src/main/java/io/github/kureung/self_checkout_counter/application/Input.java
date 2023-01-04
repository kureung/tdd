package io.github.kureung.self_checkout_counter.application;

import java.io.IOException;

public interface Input {
    int price(final int itemNumber) throws IOException;
    int quantity(final int itemNumber) throws IOException;
}
