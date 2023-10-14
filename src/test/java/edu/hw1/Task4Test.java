package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task4Test {
    @Test
    @DisplayName("Пустая строка")
    void emptyString() {
        String test = "";

        String answer = Task4.fixString(test);

        assertThat(answer).isEqualTo("");
    }

    @ParameterizedTest
    @CsvSource({"123456, 214365", "hTsii  s aimex dpus rtni.g, This is a mixed up string."})
    void ParametrizedTest(String input, String excepted) {
        String ans = Task4.fixString(input);

        assertThat(ans).isEqualTo(excepted);
    }
}
