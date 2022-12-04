package io.github.kureung;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ParticipantTest {
    @Test
    void 이름은_5글자를_초과할_수_없다() {
        assertThatThrownBy(() -> new Participant("123456"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 5글자를 초과할 수 없다.");
    }
}
