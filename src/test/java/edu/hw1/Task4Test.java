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
    @DisplayName("ParametrizedTest")
    void firstTest() {
        String test = "123456";

        String answer = Task4.fixString(test);

        assertThat(answer).isEqualTo("214365");

        String test1 = "hTsii  s aimex dpus rtni.g";

        String answer1 = Task4.fixString(test1);

        assertThat(answer1).isEqualTo("This is a mixed up string.");
    }
}
