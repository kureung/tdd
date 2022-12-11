package io.github.kureung.domain;

import java.util.List;

public record Users(List<User> values) {
    public User user(final String name) {
        return values.stream()
                .filter(user -> user.isTheSameName(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 이름입니다."));
    }

    public boolean isNotTheSameSize(final Results results) {
        return this.values.size() != results.size();
    }
}
