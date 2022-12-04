package io.github.kureung.domain;

import java.util.List;
import java.util.stream.IntStream;

public record Line(List<Boolean> doRoadsExist) {
    public Line {
        for (int i = 0; i < doRoadsExist.size() - 1; i++) {
            if (doRoadsExist.get(i) && doRoadsExist.get(i + 1)) {
                throw new IllegalArgumentException("참이 연속해서 올 수 없습니다.");
            }
        }
    }

    public Line(final boolean... doRoadsExist) {
        this(convertedCollection(doRoadsExist));
    }

    private static List<Boolean> convertedCollection(boolean... doRoadsExist) {
        return IntStream.range(0, doRoadsExist.length)
                .mapToObj(index -> doRoadsExist[index])
                .toList();
    }

}
