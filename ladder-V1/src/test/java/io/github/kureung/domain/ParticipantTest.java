package io.github.kureung.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class ParticipantTest {
    @Test
    void 이름은_5글자를_초과할_수_없다() {
        assertThatThrownBy(() -> new Participant("123456"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 5글자를 초과할 수 없다.");
    }

    @ParameterizedTest
    @NullAndEmptySource
    void 이름은_널값이거나_0자일_수_없다(final String name) {
        assertThatThrownBy(() -> new Participant(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 null 값이거나 0자일 수 없다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "1",
            "12345"
    })
    void 이름은_1자이상_5자이하이어야_한다(final String name) {
        assertThatCode(() -> new Participant(name))
                .doesNotThrowAnyException();
    }

    @Test
    void 길이_있을_경우_참여자들은_서로의_위차가_바뀐다() {
        Participant participantA = new Participant("a");
        Participant participantB = new Participant("b");
        assertThat(participantA.crossedParticipants(true, participantB))
                .isEqualTo(new CrossingResult(participantB, participantA));
    }

    @Test
    void 길이_없을_경우_참여자들은_위치가_그대로다() {
        Participant participantA = new Participant("a");
        Participant participantB = new Participant("b");
        assertThat(participantA.crossedParticipants(false, participantB))
                .isEqualTo(new CrossingResult(participantA, participantB));
    }
}
