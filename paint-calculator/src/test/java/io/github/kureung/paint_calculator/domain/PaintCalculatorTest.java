package io.github.kureung.paint_calculator.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class PaintCalculatorTest {
    @ParameterizedTest
    @CsvSource(value = {
            "9 : 1",
            "10 : 2"
    }, delimiter = ':')
    void 공간_면적을_입력받으면_필요한_페인트를_구할_수_있다(final int squareMeterArea, final int amountOfPaint) {
        final PaintCalculator paintCalculator = new PaintCalculator(squareMeterArea);
        assertThat(paintCalculator.amountOfPaintNeeded()).isEqualTo(amountOfPaint);
    }
}
