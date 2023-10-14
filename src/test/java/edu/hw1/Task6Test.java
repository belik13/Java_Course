package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task6Test {
    @Test
    @DisplayName("Одинаковые числа")
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
    @Test
    @DisplayName("ParametrizedTest")
    void ParametrizedTest() {
        int test = 6621;

        int answer = Task6.countK(test);

        assertThat(answer).isEqualTo(5);

        int test2 = 6554;

        int answer2 = Task6.countK(test2);

        assertThat(answer2).isEqualTo(4);

        int test3 = 1234;

        int answer3 = Task6.countK(test3);

        assertThat(answer3).isEqualTo(3);

    }
    @Test
    @DisplayName("Проверка одинаковых цифр")
    void TestSameDigits() {
        int test = 1111;

        int answer = Task6.countK(test);

        assertThat(answer).isEqualTo(-1);
    }
}
