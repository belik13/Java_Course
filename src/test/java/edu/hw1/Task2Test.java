package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test {
    @Test
    @DisplayName("Проверка на 0")
    void val0() {
        // given
        int test = 0;

        // when
        int ans = Task2.countDigits(test);

        // then
        assertThat(ans).isEqualTo(1);
    }

    @ParameterizedTest
    @CsvSource({"4, 1", "200, 3", "-300, 3", "45455, 5"})
    void ParametrizedTest(int input, int excepted) {
        int ans = Task2.countDigits(input);

        assertThat(ans).isEqualTo(excepted);
    }
}
