package edu.hw1;

public class Task7 {
    private Task7() {
    }

    public static int rotateRight(int k, int shiftTarget) {
        int n = k;
        int shift = shiftTarget;

        if (n < 0 || shift < 0) {
            return -1;
        }

        StringBuilder rotation = new StringBuilder(Integer.toBinaryString(k));

        shift = shift % rotation.length();

        for (int i = 0; i < shift; i++) {
            char c = rotation.charAt(rotation.length() - 1 - i);
            rotation.insert(0, c);
        }

        rotation = rotation.replace(rotation.length() - shift - shift, rotation.length() - 1, "");

        return Integer.parseInt(rotation.toString(), 2);
    }

    public static int rotateLeft(int k, int shiftTarget) {
        int n = k;
        int shift = shiftTarget;

        if (n < 0 || shift < 0) {
            return -1;
        }

        StringBuilder rotation = new StringBuilder(Integer.toBinaryString(k));

        shift = shift % rotation.length();

        for (int i = 0; i < shift; i++) {
            rotation.append(rotation.charAt(i));
        }

        rotation = rotation.replace(0, shift, "");

        return Integer.parseInt(rotation.toString(), 2);
    }
}
