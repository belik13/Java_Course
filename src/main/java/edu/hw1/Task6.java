package edu.hw1;

import java.util.Arrays;

public class Task6 {
    private Task6() {
    }

    public static boolean caprekaraCheckDigits(int check) {
        String str = Integer.toString(check);
        for (int i = 0; i < str.length() - 1; ++i) {
            if (str.charAt(i) != str.charAt(i + 1)) {
                return false;
            }
        }
        return true;
    }

    public static final int UPPER_BOUND = 9999;
    public static final int LOWER_BOUND = 1001;
    public static final int CAPREKARA_FINAL = 6174;

    public static int countK(int numberToCount) {
        if (numberToCount <= LOWER_BOUND || numberToCount >= UPPER_BOUND
            || caprekaraCheckDigits(numberToCount)) {
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



