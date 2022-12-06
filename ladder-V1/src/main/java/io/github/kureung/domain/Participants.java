package io.github.kureung.domain;

import java.util.Arrays;
import java.util.List;

public record Participants(List<Participant> values) {
    public Participants(final String... names) {
        this(convertedCollection(names));
    }

    private static List<Participant> convertedCollection(String... names) {
        return Arrays.stream(names)
                .map(Participant::new)
                .toList();
    }

    public int size() {
        return values.size();
    }

    public int participantIndex(String name) {
        Participant participant = new Participant(name);
        if (!values.contains(participant)) {
            throw new IllegalStateException("해당하는 이름을 가진 참여자가 없습니다.");
        }
        return values().indexOf(participant);
    }
}
