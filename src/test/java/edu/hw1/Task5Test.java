package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task5Test {
    @Test
    @DisplayName("ParametrizedTests")
    void firstTest() {
        int test = 11211230;

        boolean ans = Task5.isPalindromeDescendant(test);

        assertThat(ans).isEqualTo(true);

        int test1 = 13001120;

        boolean ans1 = Task5.isPalindromeDescendant(test);

        assertThat(ans1).isEqualTo(true);

        int test2 = 23336014;

        boolean ans2 = Task5.isPalindromeDescendant(test);

        assertThat(ans2).isEqualTo(true);
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
