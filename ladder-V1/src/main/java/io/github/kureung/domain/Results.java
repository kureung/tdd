package io.github.kureung.domain;

import java.util.Arrays;
import java.util.List;

public record Results(List<String> values) {
    public Results(String... values) {
        this(convertedValues(values));
    }

    private static List<String> convertedValues(String[] values) {
        return Arrays.stream(values)
                .toList();
    }

    public String value(int index) {
        return values.get(index);
    }


    public boolean isNotSameSize(Participants participants) {
        return values.size() != participants.size();
    }
}
