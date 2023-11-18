package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw5.Task7.firstPattern;
import static edu.hw5.Task7.secPattern;
import static edu.hw5.Task7.thirdPattern;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task7Test {
    @Test
    @DisplayName("Тест первого условия")
    void firstPatTest() {
        assertThat(firstPattern("100")).isEqualTo(true);
        assertThat(firstPattern("10")).isEqualTo(false);
    }
    @Test
    @DisplayName("Тест второго условия")
    void secPatTest() {
        assertThat(secPattern("101")).isEqualTo(true);
        assertThat(secPattern("100")).isEqualTo(false);
    }
    @Test
    @DisplayName("Тест третьего условия")
    void thirdPatTest() {
        assertThat(thirdPattern("10")).isEqualTo(true);
        assertThat(thirdPattern("101000")).isEqualTo(false);
    }
}
