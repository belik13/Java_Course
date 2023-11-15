package edu.hw3;

public class Task1 {
    private Task1() {

    }

    private static final int LOWER_A_CODE = 64;
    private static final int LOWER_Z_CODE = 91;
    private static final int UPPER_A_CODE = 96;
    private static final int UPPER_Z_CODE = 123;

    public static String atbash(String word) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < word.length(); ++i) {
            if ((int) word.charAt(i) > UPPER_A_CODE && (int) word.charAt(i) < UPPER_Z_CODE) {
                result.append((char) (UPPER_Z_CODE - ((int) word.charAt(i) - UPPER_A_CODE)));
            } else if ((int) word.charAt(i) > LOWER_A_CODE && (int) word.charAt(i) < LOWER_Z_CODE) {
                result.append((char) (LOWER_Z_CODE - ((int) word.charAt(i) - LOWER_A_CODE)));
            } else {
                result.append(word.charAt(i));
            }
        }
        return result.toString();
    }
}
