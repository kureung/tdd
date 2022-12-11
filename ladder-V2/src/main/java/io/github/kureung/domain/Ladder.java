package io.github.kureung.domain;

public record Ladder(Lines lines, Users users, Results results) {
    public String result(final String name) {
        final User user = users.user(name);
        final int XCoordition = lines.movedXCoordinate(user);
        return results.result(XCoordition);
    }
}

