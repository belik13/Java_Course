package edu.hw7;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static edu.hw7.Task2.factorial;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test {
    public static Stream<Arguments> inputCases() {
        return Stream.of(
            Arguments.of(5,120L),
            Arguments.of(10,3628800L),
            Arguments.of(1,1L)
        );
    }

    @ParameterizedTest
    @MethodSource("inputCases")
    @DisplayName("Factorial Test")
    void factorialTest(int number, long expected) {
        assertThat(factorial(number)).isEqualTo(expected);
    }
}
