package edu.hw5;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static edu.hw5.Task5.checkAutoPlate;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task5Test {
    private static Stream<Arguments> inputsForTests() {
        return Stream.of(
            Arguments.of("А123ВЕ777", true),
            Arguments.of("О777ОО177", true),
            Arguments.of("123АВЕ777", false),
            Arguments.of("А123ВГ77", false),
            Arguments.of("А123ВЕ7777", false));
    }

    @ParameterizedTest
    @MethodSource("inputsForTests")
    void task5Test(String plate, boolean expected) {
        assertThat(checkAutoPlate(plate)).isEqualTo(expected);
    }
}
