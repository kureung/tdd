package io.github.kureung.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ParticipantsTest {
    @Test
    void 부_생성자의_주_생성자_변환_테스트() {
        final List<Participant> Participants = List.of(new Participant("1"));
        assertThat(new Participants("1")).isEqualTo(new Participants(Participants));
    }
}
