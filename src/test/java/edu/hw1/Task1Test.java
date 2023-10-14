package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.in;

public class Task1Test {
    @ParameterizedTest
    @CsvSource({"03:00, 180", "18:20, 1100", "00:22, 22"})
    void ParametrizedTest(String input, int excepted) {
        int ans = Task1.minutesToSeconds(input);

        assertThat(ans).isEqualTo(excepted);
    }
    @Test
    @DisplayName("Проверка на 1 минуту")
     void oneMinute() {
        // given
        String test = "01:00";

        // when
        int ans = Task1.minutesToSeconds(test);

        // then
        assertThat(ans).isEqualTo(60);
    }
    @Test
    @DisplayName("Проверка на отрицательные значения")
    void negativeStr() {
        // given
        String test = "-10:00";

        // when
        int ans = Task1.minutesToSeconds(test);

        // then
        assertThat(ans).isEqualTo(-1);
    }
    @Test
    @DisplayName("Проверка на больше 60 минут")
    void moreThan60minutes() {
        // given
        String test = "770:00";

        // when
        int ans = Task1.minutesToSeconds(test);

        // then
        assertThat(ans).isEqualTo(46200);
    }
    @Test
    @DisplayName("Проверка на больше 60 секунд")
    void bigSeconds() {
        // given
        String test = "00:79";

        // when
        int ans = Task1.minutesToSeconds(test);

        // then
        assertThat(ans).isEqualTo(-1);
    }
}
