package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static edu.hw5.Task4.checkPassword;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task4Test {
    private static Stream<Arguments> inputsForTests() {
        return Stream.of(
            Arguments.of("gf!", true),
            Arguments.of("gfdg@", true),
            Arguments.of("PGFDdsa&r", true),
            Arguments.of("fkmwerf", false),
            Arguments.of("sufiuse!fkjwn", true));
    }

    @ParameterizedTest
    @MethodSource("inputsForTests")
    @DisplayName("exampleTestTask4")
    void passwordsCheck(String pass, boolean expected) {
        assertThat(checkPassword(pass)).isEqualTo(expected);
    }
}
