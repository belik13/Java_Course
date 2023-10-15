package edu.hw1;

import java.util.Arrays;

public class Task3 {
    private Task3() {
    }

    public static boolean isNestable(int[] array1, int[] array2) {
        if (array1.length > 0 && array2.length > 0) {
            return Arrays.stream(array1).min().getAsInt() > Arrays.stream(array2).min().getAsInt()
                    || Arrays.stream(array1).max().getAsInt() < Arrays.stream(array2).max().getAsInt();
        } else {
            return false;
        }
    }
}
