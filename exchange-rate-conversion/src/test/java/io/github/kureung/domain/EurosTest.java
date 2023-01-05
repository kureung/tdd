package io.github.kureung.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class EurosTest {
    @Test
    void 유로를_달러로_변환할_수_있다() {
        final Euros euros = new Euros(81);
        assertThat(euros.exchangedDollars(137.51)).isEqualTo(111.38);
    }
}
