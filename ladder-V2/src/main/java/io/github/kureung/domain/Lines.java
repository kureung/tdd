package io.github.kureung.domain;

import java.util.List;

public record Lines(List<Line> values) {
    public Lines {
        if (isNotSameLineSize(values)) {
            throw new IllegalArgumentException("각각의 행의 요소 개수가 일치하지 않습니다.");
        }
    }

    private boolean isNotSameLineSize(final List<Line> values) {
        final Line firstLine = values.get(0);
        return values.stream()
                .anyMatch(firstLine::isNotTheSameSize);
    }

    public int movedXCoordinate(final User user) {
        final User movedUser = values.stream()
                .reduce(user, User::movedUser, (user1, user2) -> user1);
        return movedUser.xCoordinate();
    }

    public int directionsSize() {
        return values.get(0).size();
    }
}
