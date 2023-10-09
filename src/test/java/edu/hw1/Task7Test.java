package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task7Test {
    @Test
    @DisplayName("Пример 1")
    void sameDigits() {
        int test = 8;
        int shift = 1;

        int answer = Task7.rotateRight(test,shift);

        assertThat(answer).isEqualTo(4);
    }
    @Test
    @DisplayName("Пример 2")
    void Test2() {
        int test = 16;
        int shift = 1;

        int answer = Task7.rotateLeft(test,shift);

        assertThat(answer).isEqualTo(1);
    }
    @Test
    @DisplayName("Пример 3")
    void Test3() {
        int test = 17;
        int shift = 2;

        int answer = Task7.rotateLeft(test,shift);

        assertThat(answer).isEqualTo(6);
    }
    @Test
    @DisplayName("Проверка больших shift")
    void highShift() {
        int test = 8;
        int shift = 25;

        int answer = Task7.rotateRight(test,shift);

        assertThat(answer).isEqualTo(4);
    }
    @Test
    @DisplayName("Отрицательные значения")
    void negativeValue() {
        int test = -5;
        int shift = 25;

        int answer = Task7.rotateRight(test,shift);

        assertThat(answer).isEqualTo(-1);
    }
    @Test
    @DisplayName("Несдвигаемое число")
    void unrotatedTest() {
        int test = 31;
        int shift = 3;

        int answer = Task7.rotateLeft(test,shift);

        assertThat(answer).isEqualTo(31);
    }
    @Test
    @DisplayName("Random тест влево")
    void randomTestLeft() {
        int test = 23;
        int shift = 1;

        int answer = Task7.rotateLeft(test,shift);

        assertThat(answer).isEqualTo(15);
    }
    @Test
    @DisplayName("Random тест вправо")
    void randomTestRight() {
        int test = 23;
        int shift = 1;

        int answer = Task7.rotateRight(test,shift);

        assertThat(answer).isEqualTo(27);
    }
}
