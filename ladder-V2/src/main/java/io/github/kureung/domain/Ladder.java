package io.github.kureung.domain;

public record Ladder(Lines lines, Users users, Results results) {
    public Ladder {
        if (users.isNotTheSameSize(results)) {
            throw new IllegalArgumentException("유저 수와 결과의 개수가 일치하지 않습니다.");
        }

        if (users.isNotTheSameSize(lines)) {
            throw new IllegalArgumentException("유저 수와 각 행의 방향 개수가 일치하지 않습니다.");
        }
    }

    public String result(final String name) {
        final User user = users.user(name);
        final int XCoordinate = lines.movedXCoordinate(user);
        return results.result(XCoordinate);
    }
}

