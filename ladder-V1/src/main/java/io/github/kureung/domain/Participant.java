package io.github.kureung.domain;

import java.util.List;

public record Participant(String name) {
    public Participant {
        if (name == null || name.length() == 0) {
            throw new IllegalArgumentException("이름은 null 값이거나 0자일 수 없다.");
        }

        if (5 < name.length()) {
            throw new IllegalArgumentException("이름은 5글자를 초과할 수 없다.");
        }
    }

    public List<Participant> crossedParticipants(boolean doesRoadExist, Participant other) {
        return doesRoadExist
                ? List.of(other, this)
                : List.of(this, other);
    }
}
