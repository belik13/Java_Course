package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task6Test {
    @Test
    @DisplayName("Не 4-х значные числа")
    void sameDigits() {
        int test = 11111;

        int answer = Task6.countK(test);

        assertThat(answer).isEqualTo(-1);
    }
    @Test
    @DisplayName("Ввод результирующего числа")
    void resValue() {
        int test = 6174;

        int answer = Task6.countK(test);

        assertThat(answer).isEqualTo(1);
    }

    @ParameterizedTest
    @CsvSource({"6621, 5", "6554, 4", "1234, 3"})
    void ParametrizedTest(int input, int excepted) {
        int ans = Task6.countK(input);

        assertThat(ans).isEqualTo(excepted);
    }
    @Test
    @DisplayName("Проверка одинаковых цифр")
    void TestSameDigits() {
        int test = 1111;

        int answer = Task6.countK(test);

        assertThat(answer).isEqualTo(-1);
    }
}
