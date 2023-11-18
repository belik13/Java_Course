package edu.hw5;

import edu.hw3.Task5.Contact;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;
import static edu.hw5.Task2.findFridays;
import static edu.hw5.Task2.findNextFriday;
import static org.assertj.core.api.Assertions.assertThat;

public class Task2Test {
    private static Stream<Arguments> exampleTest() {
        return Stream.of(Arguments.of(1925,
            List.of(LocalDate.of(1925,2,13),
                LocalDate.of(1925,3,13),
                LocalDate.of(1925,11,13))
        ),
            Arguments.of(2024,List.of(
                LocalDate.of(2024,9,13),
                LocalDate.of(2024,12,13)
            )));
    }

    @ParameterizedTest
    @MethodSource("exampleTest")
    @DisplayName("ExampleTest")
    void examplTest(int year, List<LocalDate> list) {
        assertThat(findFridays(year)).isEqualTo(list);
    }

    @Test
    @DisplayName("Ближайшая пятница")
    void nextFriday() {
        findNextFriday(LocalDate.parse("2024-12-12"))
            .isEqual(LocalDate.of(1925,3,13));
    }

}
