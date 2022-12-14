package io.github.kureung.domain;

public record Participant(String name) {
    public Participant {
        if (name == null || name.length() == 0) {
            throw new IllegalArgumentException("이름은 null 값이거나 0자일 수 없다.");
        }

        if (5 < name.length()) {
            throw new IllegalArgumentException("이름은 5글자를 초과할 수 없다.");
        }
    }

    public CrossingResult crossedParticipants(boolean doesRoadExist, Participant other) {
        return doesRoadExist
                ? new CrossingResult(other, this)
                : new CrossingResult(this, other);
    }
}
