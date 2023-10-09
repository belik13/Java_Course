package edu.hw1;

import static java.lang.Math.pow;

public class Task7 {
    private Task7() {
    }

    public static int rotateRight(int k, int shiftTarget) {
        int n = k;
        int shift = shiftTarget;

        if (n < 0 || shift < 0) {
            return -1;
        }

        StringBuilder rotation = new StringBuilder();

        while (n > 0) {
            rotation.append(n % 2);
            n /= 2;
        }

        shift = shift % rotation.length();

        rotation = rotation.reverse();
        for (int i = 0; i < shift; i++) {
            char c = rotation.charAt(rotation.length() - 1 - i);
            rotation.insert(0, c);
        }

        rotation = rotation.replace(rotation.length() - shift - shift, rotation.length() - 1, "");

        int res = 0;
        int power = 0;

        for (int i = rotation.length() - 1; i >= 0; i--) {
            if (rotation.charAt(i) == '1') {
                res += pow(2, power);
            }
            power++;
        }
        return res;
    }

    public static int rotateLeft(int k, int shiftTarget) {
        int n = k;
        int shift = shiftTarget;

        if (n < 0 || shift < 0) {
            return -1;
        }

        StringBuilder rotation = new StringBuilder();

        while (n > 0) {
            rotation.append(n % 2);
            n /= 2;
        }

        shift = shift % rotation.length();

        rotation = rotation.reverse();
        for (int i = 0; i < shift; i++) {
            rotation.append(rotation.charAt(i));
        }

        rotation = rotation.replace(0, shift, "");

        int res = 0;
        int power = 0;

        for (int i = rotation.length() - 1; i >= 0; i--) {
            if (rotation.charAt(i) == '1') {
                res += pow(2, power);
            }
            power++;
        }
        return res;
    }
}
