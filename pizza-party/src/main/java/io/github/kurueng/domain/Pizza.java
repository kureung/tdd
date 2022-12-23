package io.github.kurueng.domain;

public record Pizza(int pieces) {
    public Pizza {
        if (pieces <= 0) {
            throw new IllegalArgumentException("피자 조각 개수는 양수이어야 합니다.");
        }
    }
}
