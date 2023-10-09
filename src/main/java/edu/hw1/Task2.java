package edu.hw1;

import static java.lang.Math.abs;

public class Task2 {
    private Task2() {
    }

    private static final int STEP = 10;

    public static int countDigits(int value) {
        int digCounter = 0;

        int temp = abs(value);

       do {
            digCounter++;
            temp /= STEP;
        } while (temp > 0);

        return digCounter;
    }
}
