package io.github.kureung.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UsersTest {
    @Test
    void 이름으로_유저를_조회할_수_있다() {
        final Users users = new Users(List.of(new User("a", 0)));
        assertThat(users.user("a")).isEqualTo(new User("a", 0));
    }

    @Test
    void 유저를_조회할_때_존재하지_않는_이름일_경우_예외가_발생한다() {
        final Users users = new Users(List.of(new User("a", 0)));
        assertThatThrownBy(() -> users.user("b"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("존재하지 않는 이름입니다.");
    }
}
