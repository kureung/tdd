package io.github.kureung.domain;

public record User(String name) {
    public User {
        if (5 < name.length()) {
            throw new IllegalArgumentException("이름은 5자를 초과할 수 없습니다.");
        }
    }
}
