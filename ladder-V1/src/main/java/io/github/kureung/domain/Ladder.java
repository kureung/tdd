package io.github.kureung.domain;

public record Ladder(Participants participants, Lines lines, Results results) {
    public Ladder {
        if (results.isNotSameSize(participants)) {
            throw new IllegalArgumentException("참여자들의 수와 결과들의 개수는 같아야합니다.");
        }
    }

    public String result(String name) {
        final Participants afterCrossing = lines.participantsCrossingTheRoad(participants);
        final int resultIndex = afterCrossing.participantIndex(name);
        return results.value(resultIndex);
    }
}
