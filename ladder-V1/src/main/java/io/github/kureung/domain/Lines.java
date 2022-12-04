package io.github.kureung.domain;

import java.util.Arrays;
import java.util.List;

public record Lines(List<Line> values) {
    public Lines(final Line... lines) {
        this(convertedCollection(lines));
    }

    private static List<Line> convertedCollection(Line... lines) {
        return Arrays.stream(lines)
                .toList();
    }
}
