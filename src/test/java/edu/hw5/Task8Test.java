package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw5.Task8.ifAllOddSymbolsAre1;
import static edu.hw5.Task8.isLengthOdd;
import static edu.hw5.Task8.isNumberOfNullDivisibleByThree;
import static edu.hw5.Task8.isStringWithout11or111;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task8Test {
    @Test
    @DisplayName("Проверка нечетной длины")
    void firstTask() {
        assertThat(isLengthOdd("101")).isEqualTo(true);
        assertThat(isLengthOdd("1011")).isEqualTo(false);
    }

    @Test
    @DisplayName("Количество 0 кратно 3")
    void thirdTask() {
        assertThat(isNumberOfNullDivisibleByThree("000111")).isEqualTo(true);
        assertThat(isNumberOfNullDivisibleByThree("0000111")).isEqualTo(false);
    }

    @Test
    @DisplayName("Любая строка, кроме 11 или 111")
    void fourthTask() {
        assertThat(isStringWithout11or111("111")).isEqualTo(false);
        assertThat(isStringWithout11or111("000011")).isEqualTo(true);
    }

    @Test
    @DisplayName("Каждый нечетный символ равен 1")
    void fifthTask() {
        assertThat(ifAllOddSymbolsAre1("100")).isEqualTo(false);
        assertThat(ifAllOddSymbolsAre1("10101")).isEqualTo(true);
    }
}
