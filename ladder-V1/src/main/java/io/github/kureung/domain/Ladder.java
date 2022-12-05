package io.github.kureung.domain;

public record Ladder(Participants participants, Lines lines, Results results) {
    public Ladder {
        if (results.isNotSameSize(participants)) {
            throw new IllegalArgumentException("참여자들의 수와 결과들의 개수는 같아야합니다.");
        }
    }
}
