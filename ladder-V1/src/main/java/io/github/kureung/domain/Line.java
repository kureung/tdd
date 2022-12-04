package io.github.kureung.domain;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.stream.IntStream;

public record Line(List<Boolean> doRoadsExist) {
    public Line {
        for (int i = 0; i < doRoadsExist.size() - 1; i++) {
            if (doRoadsExist.get(i) && doRoadsExist.get(i + 1)) {
                throw new IllegalArgumentException("참이 연속해서 올 수 없습니다.");
            }
        }
    }

    public Line(final boolean... doRoadsExist) {
        this(convertedCollection(doRoadsExist));
    }

    private static List<Boolean> convertedCollection(boolean... doRoadsExist) {
        return IntStream.range(0, doRoadsExist.length)
                .mapToObj(index -> doRoadsExist[index])
                .toList();
    }

    public int size() {
        return doRoadsExist.size();
    }

    public boolean isNotSameSize(int size) {
        return size() != size;
    }

    public Participants ParticipantsCrossedTheRoad(Participants beforeCrossing) {
        final Deque<Boolean> doRoadsExistCollection = new ArrayDeque<>(doRoadsExist);
        final List<Participant> afterCrossing = new ArrayList<>(beforeCrossing.values());
        crossTheRoad(beforeCrossing, doRoadsExistCollection, afterCrossing);
        return new Participants(afterCrossing);
    }

    private void crossTheRoad(Participants beforeCrossing, Deque<Boolean> copiedDoRoadsExist, List<Participant> afterCrossing) {
        for (int index = 0; index < beforeCrossing.size() - 1; index++) {
            Participant current = afterCrossing.get(index);
            Participant next = afterCrossing.get(index + 1);
            CrossingResult crossingResult = current.crossedParticipants(copiedDoRoadsExist.poll(), next);
            afterCrossing.set(index, crossingResult.preParticipant());
            afterCrossing.set(index + 1, crossingResult.postParticipant());
        }
    }
}
