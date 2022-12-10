package io.github.kureung.domain;

import java.util.Arrays;
import java.util.List;

import static io.github.kureung.domain.Direction.RIGHT;

public record Line(List<Point> points) {
    public Line {
        verifyFirstPointDirections(points);
        verifyLastPointDirections(points);

        for (int index = 0; index < points.size() - 1; index++) {
            final Point currentPoint = points.get(index);
            final Point nextPoint = points.get(index + 1);
            verifySameDirectionsExcludeBottom(currentPoint, nextPoint);
            verifyRightComeAfterLeft(currentPoint, nextPoint);
        }
    }

    public Line(final Point... points) {
        this(convertedCollection(points));
    }

    private static List<Point> convertedCollection(final Point... points) {
        return Arrays.stream(points).toList();
    }

    private void verifyFirstPointDirections(final List<Point> points) {
        final Point firstPoint = points.get(0);
        if (firstPoint.isIncludeDirection(Direction.LEFT)) {
            throw new IllegalArgumentException("행의 첫번째 요소에는 왼쪽 방향을 가진 지점이 올 수 없습니다.");
        }
    }

    private void verifyLastPointDirections(final List<Point> points) {
        final Point lastPoint = points.get(points.size() - 1);
        if (lastPoint.isIncludeDirection(RIGHT)) {
            throw new IllegalArgumentException("행의 마지막 요소에는 오른쪽 방향을 가진 지점이 올 수 없습니다.");
        }

    }

    private void verifySameDirectionsExcludeBottom(final Point currentPoint, final Point nextPoint) {
        if (currentPoint.doesntHaveOnlyBottom() && currentPoint.isSameDirections(nextPoint)) {
            throw new IllegalArgumentException("오른쪽 방향 또는 왼쪽 방향이 연속으로 있을 수 없습니다.");
        }
    }

    private void verifyRightComeAfterLeft(final Point currentPoint, final Point nextPoint) {
        if (currentPoint.isIncludeDirection(RIGHT) && nextPoint.isNotIncludeDirection(Direction.LEFT)) {
            throw new IllegalArgumentException("오른쪽 방향을 가진 지점 다음에는 왼쪽 방향을 가진 지점이 와야합니다.");
        }
    }
}
