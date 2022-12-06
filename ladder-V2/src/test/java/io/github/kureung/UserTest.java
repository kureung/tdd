package io.github.kureung;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;

class UserTest {
    @ParameterizedTest
    @ValueSource(strings = {
            "1",
            "12345"
    })
    void 유저의_이름은_1자_이상_5자_이하이어야_한다(String name) {
        assertThatCode(() -> new User(name))
                .doesNotThrowAnyException();
    }
}
