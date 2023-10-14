package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task5Test {
    @ParameterizedTest
    @CsvSource({"11211230, true", "13001120, true", "23336014, true"})
    void ParametrizedTest(int input, boolean excepted) {
        boolean ans = Task5.isPalindromeDescendant(input);

        assertThat(ans).isEqualTo(excepted);
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
