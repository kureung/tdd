package io.github.kureung.domain;

import java.util.List;
import java.util.stream.IntStream;

public record Line(List<Boolean> doRoadsExist) {
    public Line(final boolean... doRoadsExist) {
        this(convertedCollection(doRoadsExist));
    }

    private static List<Boolean> convertedCollection(boolean... doRoadsExist) {
        return IntStream.range(0, doRoadsExist.length)
                .mapToObj(index -> doRoadsExist[index])
                .toList();
    }

}
