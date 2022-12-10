package io.github.kureung.domain;

import java.util.List;

public record Line(List<Point> points) {
    public Line {
        for (int index = 0; index < points.size() - 1; index++) {
            final Point currentPoint = points.get(index);
            final Point nextPoint = points.get(index + 1);
            verifySameDirectionsExcludeBottom(currentPoint, nextPoint);
        }
    }

    private void verifySameDirectionsExcludeBottom(final Point currentPoint, final Point nextPoint) {
        if (currentPoint.doesntHaveOnlyBottom() &&  currentPoint.isSameDirections(nextPoint)) {
            throw new IllegalArgumentException("오른쪽 방향 또는 왼쪽 방향이 연속으로 있을 수 없습니다.");
        }
    }
}
