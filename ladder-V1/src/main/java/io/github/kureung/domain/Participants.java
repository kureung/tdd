package io.github.kureung.domain;

import java.util.Arrays;
import java.util.List;

public record Participants(List<Participant> values) {
    public Participants(final String... names) {
        this(convertedCollection(names));
    }

    private static List<Participant> convertedCollection(String... names) {
        return Arrays.stream(names)
                .map(Participant::new)
                .toList();
    }

    public int size() {
        return values.size();
    }
}
