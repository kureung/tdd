package io.github.kureung.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserTest {
    @ParameterizedTest
    @ValueSource(strings = {
            "1",
            "12345"
    })
    void 유저의_이름은_1자_이상_5자_이하이어야_한다(String name) {
        assertThatCode(() -> new User(name, 0))
                .doesNotThrowAnyException();
    }

    @Test
    void 유저의_이름은_5자_초과했을_경우_예외가_발생한다() {
        final String name = "123456";
        assertThatThrownBy(() -> new User(name, 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 5자를 초과할 수 없습니다.");
    }
}
