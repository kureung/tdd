package io.github.kureung.domain;

import java.util.List;

public record Results(List<String> values) {
    public String result(final int index) {
        return values.get(index);
    }
}
