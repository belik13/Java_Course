package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task4Test {
    @Test
    @DisplayName("Пустая строка")
    void emptyString() {
        String test = "";

        String answer = Task4.fixString(test);

        assertThat(answer).isEqualTo("");
    }
    @Test
    @DisplayName("First check")
    void firstTest() {
        String test = "123456";

        String answer = Task4.fixString(test);

        assertThat(answer).isEqualTo("214365");
    }
    @Test
    @DisplayName("Sec check")
    void secTest() {
        String test = "hTsii  s aimex dpus rtni.g";

        String answer = Task4.fixString(test);

        assertThat(answer).isEqualTo("This is a mixed up string.");
    }
}
