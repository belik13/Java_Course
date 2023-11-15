package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static edu.hw3.Task2.clusterize;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test {
    private static Stream<Arguments> exampleTest() {
        return Stream.of(
            Arguments.of("()()()", new String[] {"()", "()", "()"}),
            Arguments.of("((()))", new String[] {"((()))"}),
            Arguments.of("((()))(())()()(()())", new String[] {"((()))", "(())", "()", "()", "(()())"}),
            Arguments.of("((())())(()(()()))", new String[] {"((())())", "(()(()()))"})
        );
    }

    @ParameterizedTest
    @DisplayName("Example")
    @MethodSource("exampleTest")
    void exampleTest(String brackets, String[] excepted) {
        String[] ans = clusterize(brackets).toArray(new String[0]);
        assertThat(ans).isEqualTo(excepted);
    }
}
