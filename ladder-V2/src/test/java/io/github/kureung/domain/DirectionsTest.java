package io.github.kureung.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.params.provider.EnumSource.Mode.EXCLUDE;

class DirectionsTest {
    @ParameterizedTest
    @EnumSource(mode = EXCLUDE, names = "BOTTOM")
    void 방향들은_BOTTOM_방향을_가지고_있지_않으면_예외가_발생한다(Direction direction) {
        assertThatThrownBy(() -> new Directions(List.of(direction)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("무조건 아래로 가는 방향을 가지고 있어야 합니다.");
    }

    @Test
    void 방향들이_BOTTOM_방향만_가지면_참이다() {
        final Directions directions = new Directions(List.of(Direction.BOTTOM));
        assertTrue(directions.doesHaveOnlyBottom());
    }
}
