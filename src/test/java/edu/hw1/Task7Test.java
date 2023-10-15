package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.in;

public class Task7Test {
    @DisplayName("ParametrizedTestLeft")
    @ParameterizedTest
    @CsvSource({"16, 1, 1", "17, 2, 6", "23, 1, 15"})
    void ParametrizedTestLeft(int input, int shift, int excepted) {
        int ans = Task7.rotateLeft(input, shift);

        assertThat(ans).isEqualTo(excepted);
    }

    @DisplayName("ParametrizedTestRight")
    @ParameterizedTest
    @CsvSource({"23, 1, 27", "8, 1, 4"})
    void ParametrizedTestRight(int input, int shift, int excepted) {
        int ans = Task7.rotateRight(input, shift);

        assertThat(ans).isEqualTo(excepted);
    }

    @Test
    @DisplayName("Проверка больших shift")
    void highShift() {
        int test = 8;
        int shift = 25;

        int answer = Task7.rotateRight(test, shift);

        assertThat(answer).isEqualTo(4);
    }

    @Test
    @DisplayName("Отрицательные значения")
    void negativeValue() {
        int test = -5;
        int shift = 25;

        int answer = Task7.rotateRight(test, shift);

        assertThat(answer).isEqualTo(-1);
    }

    @Test
    @DisplayName("Несдвигаемое число")
    void unrotatedTest() {
        int test = 31;
        int shift = 3;

        int answer = Task7.rotateLeft(test, shift);

        assertThat(answer).isEqualTo(31);
    }
}
