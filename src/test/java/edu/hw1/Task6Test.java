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
    @DisplayName("Первый тест")
    void Test1() {
        int test = 6621;

        int answer = Task6.countK(test);

        assertThat(answer).isEqualTo(5);
    }
    @Test
    @DisplayName("Второй тест")
    void Test2() {
        int test = 6554;

        int answer = Task6.countK(test);

        assertThat(answer).isEqualTo(4);
    }
    @Test
    @DisplayName("Третий тест")
    void Test3() {
        int test = 1234;

        int answer = Task6.countK(test);

        assertThat(answer).isEqualTo(3);
    }
}
