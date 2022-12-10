package io.github.kureung.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.params.provider.EnumSource.Mode.EXCLUDE;

class DirectionsTest {
    private static Stream<Arguments> Bottom_방향을_가지고_있으며_방향의_개수는_1개_또는_2개이어야_예외가_발생하지_않는다() {
        return Stream.of(
                Arguments.of(List.of(Direction.BOTTOM)),
                Arguments.of(List.of(Direction.BOTTOM, Direction.RIGHT))
        );
    }

    @ParameterizedTest
    @EnumSource(mode = EXCLUDE, names = "BOTTOM")
    void 방향들은_BOTTOM_방향을_가지고_있지_않으면_예외가_발생한다(Direction direction) {
        assertThatThrownBy(() -> new Directions(List.of(direction)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("무조건 아래로 가는 방향을 가지고 있어야 합니다.");
    }

    @Test
    void 방향의_개수가_0개이거나_3개_이상일_경우_예외가_발생한다() {
        List<Direction> values = List.of(Direction.BOTTOM, Direction.RIGHT, Direction.LEFT);
        assertThatThrownBy(() -> new Directions(values))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("방향의 개수는 1개 또는 2개 이어야합니다.");
    }

    @MethodSource
    @ParameterizedTest
    void Bottom_방향을_가지고_있으며_방향의_개수는_1개_또는_2개이어야_예외가_발생하지_않는다(List<Direction> values) {
        assertThatCode(() -> new Directions(values))
                .doesNotThrowAnyException();
    }

    @Test
    void 방향들이_BOTTOM_방향만_가지면_참이다() {
        final Directions directions = new Directions(List.of(Direction.BOTTOM));
        assertTrue(directions.doesHaveOnlyBottom());
    }

    @Test
    void 방향의_개수가_2개일_경우_Bottom_방향이_아닌_다른_방향을_조회할_수_있다() {
        final List<Direction> values = List.of(Direction.BOTTOM, Direction.RIGHT);
        final Directions directions = new Directions(values);
        assertThat(directions.directionNotBottom()).isEqualTo(Direction.RIGHT);
    }

    @Test
    void 방향의_개수가_1개이며_Bottom_방향이_아닌_다른_방향을_조회하려고_할_경우_예외가_발생한다() {
        final Directions directions = new Directions(List.of(Direction.BOTTOM));
        assertThatThrownBy(() -> directions.directionNotBottom())
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("아래로 가는 방향만 존재합니다.");
    }

    @Test
    void Bottom_방향을_조회할_수_있다() {
        final Directions directions = new Directions(List.of(Direction.BOTTOM));
        assertThat(directions.bottom()).isEqualTo(Direction.BOTTOM);
    }

    @Test
    void 해당하는_방향을_포함하는지_판별할_수_있다() {
        final Directions directions = new Directions(Direction.RIGHT, Direction.BOTTOM);
        assertTrue(directions.isIncludeDirection(Direction.RIGHT));
    }
}