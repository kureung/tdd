package io.github.kureung.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LineTest {
    private static Stream<Arguments> 참여자들은_길을_건널_수_있다() {
        return Stream.of(
                Arguments.of(new Participants("a", "b"), new Line(true), new Participants("b", "a")),
                Arguments.of(new Participants("a", "b"), new Line(false), new Participants("a", "b")),
                Arguments.of(new Participants("a", "b", "c", "d"),  new Line(true, false, true), new Participants("b", "a", "d", "c"))
        );
    }

    @Test
    void 부_생성자의_주_생성자_변환_테스트() {
        final List<Boolean> doRoadsExist = List.of(true);
        assertThat(new Line(true)).isEqualTo(new Line(doRoadsExist));
    }

    @Test
    void 참이_여러개_일경우_예외가_발생한다() {
        final List<Boolean> doRoadsExist = List.of(true, true);
        assertThatThrownBy(() -> new Line(doRoadsExist))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("참이 연속해서 올 수 없습니다.");
    }

    @Test
    void 행의_요소의_개수를_구할_수_있다() {
        final Line line = new Line(true);
        assertThat(line.size()).isEqualTo(1);
    }

    @Test
    void 요소의_개수가_다른지_판별할_수_있다() {
        final Line line = new Line(true);
        assertAll(
                () -> assertTrue(line.isNotSameSize(2)),
                () -> assertFalse(line.isNotSameSize(1))
        );
    }

    @MethodSource
    @ParameterizedTest
    void 참여자들은_길을_건널_수_있다(Participants beforeCrossing, Line line, Participants afterCrossing) {
        assertThat(line.ParticipantsCrossedTheRoad(beforeCrossing)).isEqualTo(afterCrossing);
    }

    @Test
    void 참여자들의_수가_행의_요소의_개수보다_1개_더_많지_않으면_예외가_발생한다() {
        Participants participants = new Participants("a", "b");
        Line line = new Line(true, false);
        assertThatThrownBy(() -> line.ParticipantsCrossedTheRoad(participants))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("참여자들의 수가 행의 요소의 개수 보다 1개 더 많아야 합니다.");
    }
}
