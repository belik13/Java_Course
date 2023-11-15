package edu.hw3;

import edu.hw3.Task3.*;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static edu.hw3.Task3.freqDict;

public class Task3Test {
    private static Stream<Arguments> exampleTest() {
        return Stream.of(
            Arguments.of(List.of("a", "bb", "a", "bb"), Map.of("bb", 2L, "a", 2L)),
            Arguments.of(List.of("this", "and", "that", "and"), Map.of("that", 1L, "and", 2L, "this", 1L)),
            Arguments.of(List.of("код", "код", "код", "bug"), Map.of("код", 3L, "bug", 1L)),
            Arguments.of(List.of(1, 1, 2, 2), Map.of(1, 2L, 2, 2L))
        );
    }

    @ParameterizedTest
    @DisplayName("ExampleTest")
    @MethodSource("exampleTest")
    public <T> void exampleTest(List<T> list, Map<T, Long> excepted) {
        Map<T, Long> ans = freqDict(list);

        Assertions.assertThat(ans).isEqualTo(excepted);
    }
}
