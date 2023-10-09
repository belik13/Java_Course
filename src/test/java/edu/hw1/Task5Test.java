package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task5Test {
    @Test
    @DisplayName("Первый тест")
    void firstTest() {
        int test = 11211230;

        boolean ans = Task5.isPalindromeDescendant(test);

        assertThat(ans).isEqualTo(true);
    }
    @Test
    @DisplayName("Второй тест")
    void secTest() {
        int test = 13001120;

        boolean ans = Task5.isPalindromeDescendant(test);

        assertThat(ans).isEqualTo(true);
    }
    @Test
    @DisplayName("Третий тест")
    void thirdTest() {
        int test = 23336014;

        boolean ans = Task5.isPalindromeDescendant(test);

        assertThat(ans).isEqualTo(true);
    }
    @Test
    @DisplayName("Изначальный палиндром")
    void palindromecheck() {
        int test = 11;

        boolean ans = Task5.isPalindromeDescendant(test);

        assertThat(ans).isEqualTo(true);
    }
    @Test
    @DisplayName("Нечетная длина числа")
    void oddValueOfLength() {
        int test = 131;

        boolean ans = Task5.isPalindromeDescendant(test);

        assertThat(ans).isEqualTo(false);
    }
    @Test
    @DisplayName("Не палиндром")
    void falseException() {
        int test = 1454;

        boolean ans = Task5.isPalindromeDescendant(test);

        assertThat(ans).isEqualTo(false);
    }
}
