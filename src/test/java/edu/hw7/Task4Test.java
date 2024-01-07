package edu.hw7;

import org.assertj.core.data.Offset;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw7.Task4.oneThreadSolution;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task4Test {
    @Test
    @DisplayName("piCalcultaingTestOneThread")
    void oneThreadTest() {
        double actual = oneThreadSolution(10000000L);
        assertThat(actual).isCloseTo(Math.PI, Offset.offset(0.01));
    }

    @Test
    @DisplayName("piCalcultaingTestMultiThread")
    void multiThreadTest() {
        double actual = oneThreadSolution(10000000L);
        assertThat(actual).isCloseTo(Math.PI, Offset.offset(0.01));
    }
}
