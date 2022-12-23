package io.github.kurueng.domain;

public record People(int countPeople) {
    public People {
        if (countPeople <= 0) {
            throw new IllegalArgumentException("사람 수는 양수이어야 합니다.");
        }
    }
}
