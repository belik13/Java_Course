package edu.hw3;

import edu.hw3.Task4.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import static edu.hw3.Task4.convertToRoman;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class Task4Test {
    private static Stream<Arguments> exampleTestTask4() {
        return Stream.of(
            Arguments.of(2, "II"),
            Arguments.of(12, "XII"),
            Arguments.of(16, "XVI"),
            Arguments.of(15, "XV")
        );
    }

    @ParameterizedTest
    @MethodSource("exampleTestTask4")
    @DisplayName("ExampleTest")
    void exampleTest(int number, String excepted) {
        String ans = convertToRoman(number);

        assertThat(ans).isEqualTo(excepted);
    }

    @Test
    @DisplayName("Illegal argument exception test")
    void exceptionTest() {
        int check = 4000;
        assertThatThrownBy(() -> convertToRoman(check)).isInstanceOf(IllegalArgumentException.class);
    }
}
