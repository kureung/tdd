package io.github.kurueng.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PeopleTest {
    @ParameterizedTest
    @ValueSource(ints = {
            -1,
            0
    })
    void 사람_수는_양수가_아닐경우_예외가_발생한다(final int countPeople) {
        assertThatThrownBy(() -> new People(countPeople))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사람 수는 양수이어야 합니다.");
    }
}
