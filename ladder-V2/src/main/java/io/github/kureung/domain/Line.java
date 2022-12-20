package io.github.kureung.domain;

import java.util.Arrays;
import java.util.List;

import static io.github.kureung.domain.Direction.LEFT_AND_BOTTOM;
import static io.github.kureung.domain.Direction.RIGHT_AND_BOTTOM;

public record Line(List<Direction> directions) {
    public Line {
        verifyFirstDirection(directions);
        verifyLastDirection(directions);

        for (int i = 0; i < directions.size() - 1; i++) {
            final Direction current = directions.get(i);
            final Direction next = directions.get(i + 1);
            verifyRightComeAfterLeft(current, next);
            verifyLeftComeAfterLeft(current, next);
        }
    }

    public Line(final Direction... directions) {
        this(convertedCollection(directions));
    }

    private static List<Direction> convertedCollection(final Direction... directions) {
        return Arrays.stream(directions)
                .toList();
    }

    private void verifyFirstDirection(final List<Direction> directions) {
        final Direction firstDirection = directions.get(0);
        if (firstDirection == LEFT_AND_BOTTOM) {
            throw new IllegalArgumentException("첫번째 방향이 왼쪽일 수 없습니다.");
        }
    }

    private void verifyLastDirection(final List<Direction> directions) {
        final Direction lastDirection = directions.get(directions.size() - 1);
        if (lastDirection == RIGHT_AND_BOTTOM) {
            throw new IllegalArgumentException("마지막번째 방향이 오른쪽일 수 없습니다.");
        }
    }

    private void verifyRightComeAfterLeft(final Direction current, final Direction next) {
        if (current.isTheSame(RIGHT_AND_BOTTOM) && next.isNotTheSame(LEFT_AND_BOTTOM)) {
            throw new IllegalArgumentException("오른쪽 방향 다음에는 왼쪽 방향이 와야합니다.");
        }
    }

    private void verifyLeftComeAfterLeft(final Direction current, final Direction next) {
        if (current.isTheSame(LEFT_AND_BOTTOM) && next.isTheSame(LEFT_AND_BOTTOM)) {
            throw new IllegalArgumentException("왼쪽 방향이 연속으로 올 수 없습니다.");
        }
    }

    public Position movedPosition(final Position position) {
        final int xCoordinate = position.xCoordinate();
        verifyValidXCoordinate(xCoordinate);
        final Direction direction = directions.get(xCoordinate);
        return position.movedPosition(direction);
    }

    private void verifyValidXCoordinate(final int xCoordinate) {
        if (xCoordinate < 0 || directions.size() <= xCoordinate) {
            throw new IllegalArgumentException("포지션의 x 좌표가 유효하지 않습니다.");
        }
    }

    public boolean isNotTheSameSize(final Line target) {
        return this.directions.size() != target.directions.size();
    }

    public int size() {
        return directions.size();
    }
}
