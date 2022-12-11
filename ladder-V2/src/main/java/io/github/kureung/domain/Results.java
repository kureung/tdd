package io.github.kureung.domain;

import java.util.List;

public record Results(List<String> values) {
    public String result(final int index) {
        if (index < 0 || values.size() <= index) {
            throw new IllegalArgumentException("인덱스가 올바르지 않습니다.");
        }
        return values.get(index);
    }
}
