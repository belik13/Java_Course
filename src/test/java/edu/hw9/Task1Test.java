package edu.hw9;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task1Test {
    private static Stream<Arguments> testCases() {
        return Stream.of(
            Arguments.of(
                "metric",
                new double[] {0.1, 0.05, 1.4, 5.1, 0.3},
                Map.ofEntries(
                    Map.entry("metric_sum", 0.1 + 0.05 + 1.4 + 5.1 + 0.3),
                    Map.entry("metric_avg", 1.39),
                    Map.entry("metric_max", 5.1),
                    Map.entry("metric_min", 0.05)
                )
            )
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    @DisplayName("stats Test")
    public void statsTest(
        String name,
        double[] values,
        Map<String, Double> expectedResult
    ) throws ExecutionException, InterruptedException {

        var statsCollector = new Task1();
        statsCollector.push(name, values);

        Map<String, Double> result = null;

        result = statsCollector.stats();

        assertEquals(
            expectedResult.entrySet(),
            result.entrySet()
        );
    }
}
