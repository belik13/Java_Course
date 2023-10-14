package edu.hw1;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task3Test {
    @Test
    @DisplayName("Проверка на пустых массивах")
    void neastedArrays() {
        int testArray[] = new int[] {};
        int testArray2[] = new int[] {};

        boolean ans = Task3.isNestable(testArray, testArray2);

        assertThat(ans).isEqualTo(false);
    }

    static Stream<Arguments> trueArrays() {
        return Stream.of(
            Arguments.of(new int[] {1, 2, 3, 4}, new int[] {0, 6}),
            Arguments.of(new int[] {3, 1}, new int[] {4, 0})
        );
    }

    static Stream<Arguments> falseArrays() {
        return Stream.of(
            Arguments.of(new int[] {9, 9, 8}, new int[] {8, 9}),
            Arguments.of(new int[] {1, 2, 3, 4}, new int[] {2, 3})
        );
    }

    @DisplayName("ParameterizedTestTrue")
    @ParameterizedTest
    @MethodSource("trueArrays")
    void parametrizedTestTrue(int[] arr, int[] arr1) {
        boolean ans = Task3.isNestable(arr, arr1);
        assertThat(ans).isEqualTo(true);
    }

    @DisplayName("ParameterizedTestFalse")
    @ParameterizedTest
    @MethodSource("falseArrays")
    void parametrizedTestFalse(int[] arr, int[] arr1) {
        boolean ans = Task3.isNestable(arr, arr1);
        assertThat(ans).isEqualTo(false);
    }
}
