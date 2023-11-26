package edu.hw7;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.LongStream;

public class Task4 {
    private Task4() {

    }

    @SuppressWarnings("MagicNumber")
    public static double oneThreadSolution(long totalCount) {
        long circleCount = 0;

        for (long i = 0; i < totalCount; i++) {
            double pointX = ThreadLocalRandom.current().nextDouble(1);
            double pointY = ThreadLocalRandom.current().nextDouble(1);

            circleCount += (Math.pow(pointX, 2) + Math.pow(pointY, 2) <= 1) ? 1 : 0;
        }
        return 4 * (double) circleCount / totalCount;
    }

    @SuppressWarnings("MagicNumber")
    public static double multiThreadSoluton(long totalCount) {
        long circleCount = LongStream.rangeClosed(1, totalCount).parallel()
            .filter(point -> {
                double pointX = ThreadLocalRandom.current().nextDouble(1);
                double pointY = ThreadLocalRandom.current().nextDouble(1);
                return Math.pow(pointX, 2) + Math.pow(pointY, 2) <= 1;
            })
            .count();

        return 4 * (double) circleCount / totalCount;
    }
}
