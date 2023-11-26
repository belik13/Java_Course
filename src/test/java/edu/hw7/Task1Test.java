package edu.hw7;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task1Test {
    public static Stream<Arguments> inputCases() {
        return Stream.of(
            Arguments.of(1000),
            Arguments.of(999),
            Arguments.of(777777)
        );
    }

    @ParameterizedTest
    @MethodSource("inputCases")
    @DisplayName("threadTest")
    void test(int testInt) throws InterruptedException {
    Task1 check = new Task1();

    Thread t1 = new Thread(() -> {
        for (int i = 0; i < testInt / 2 + testInt % 2;++i){
            check.increment();
        }
    });

    Thread t2 = new Thread(() -> {
        for (int i = 0; i < testInt / 2;++i){
            check.increment();
        }
    });

    t1.start();
    t2.start();

    try {
        t1.join();
        t2.join();
    } catch (InterruptedException e) {
        throw new InterruptedException();
    }

    assertThat(testInt).isEqualTo(check.getCount());
    }
}
