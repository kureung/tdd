package io.github.kureung;

public record Participant(String name) {
    public Participant {
        if (5 < name.length()) {
            throw new IllegalArgumentException("이름은 5글자를 초과할 수 없다.");
        }
    }
}
