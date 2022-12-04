package io.github.kureung.domain;

import java.util.Arrays;
import java.util.List;

public record Lines(List<Line> values) {
    public Lines {
        if (isNotSameEachLineSize(values)) {
            throw new IllegalArgumentException("각각의 행들의 요소의 개수가 모두 같아야합니다.");
        }
    }

    public Lines(final Line... lines) {
        this(convertedCollection(lines));
    }

    private static List<Line> convertedCollection(Line... lines) {
        return Arrays.stream(lines)
                .toList();
    }

    private boolean isNotSameEachLineSize(List<Line> values) {
        final int firstLineSize = values.get(0).size();
        return values.stream()
                .anyMatch(line -> line.isNotSameSize(firstLineSize));
    }
}
