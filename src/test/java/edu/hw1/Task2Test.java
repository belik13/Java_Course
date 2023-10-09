package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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
    @Test
    @DisplayName("Проверка на случайном числе")
    void randomValTest() {
        int test = 432;
        int ans = Task2.countDigits(test);
        assertThat(ans).isEqualTo(3);
    }
    @Test
    @DisplayName("Проверка на отрицательном числе")
    void negativeTest() {
        int test = -432;
        int ans = Task2.countDigits(test);
        assertThat(ans).isEqualTo(3);
    }
}
