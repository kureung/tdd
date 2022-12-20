package io.github.kureung.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WordTest {
    @Test
    void 단어의_글자수를_구할_수_있다() {
        final Word word = new Word("abc");
        assertThat(word.length()).isEqualTo(3);
    }
}
