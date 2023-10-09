package edu.hw1;

import java.util.Arrays;

public class Task6 {
    private Task6() {
    }

    public static final int UPPER_BOUND = 9999;
    public static final int LOWER_BOUND = 1001;
    public static final int CAPREKARA_FINAL = 6174;
    public static final int WRONG_1 = 1111;
    public static final int WRONG_2 = 2222;
    public static final int WRONG_3 = 3333;
    public static final int WRONG_4 = 4444;
    public static final int WRONG_5 = 5555;
    public static final int WRONG_6 = 6666;
    public static final int WRONG_7 = 7777;
    public static final int WRONG_8 = 8888;
    public static final int WRONG_9 = 9999;

    public static int countK(int numberToCount) {
        if (numberToCount <= LOWER_BOUND || numberToCount >= UPPER_BOUND || numberToCount == WRONG_1
            || numberToCount == WRONG_2 || numberToCount == WRONG_3 || numberToCount == WRONG_4
            || numberToCount == WRONG_5 || numberToCount == WRONG_6 || numberToCount == WRONG_7
            || numberToCount == WRONG_8 || numberToCount == WRONG_9) {
            return -1;
        }

        char[] digits = String.valueOf(numberToCount).toCharArray();
        Arrays.sort(digits);
        String sortedDigits = new String(digits);

        int smallNumber = Integer.parseInt(sortedDigits);
        int bigNumber = Integer.parseInt(String.valueOf(new StringBuilder(sortedDigits).reverse()));

        int nextNumber = bigNumber - smallNumber;

        if (nextNumber == CAPREKARA_FINAL) {
            return 1;
        } else if (nextNumber == 0) {
            return -1;
        }
        return 1 + countK(nextNumber);
    }

}



