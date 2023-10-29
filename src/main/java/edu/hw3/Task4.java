package edu.hw3;

import java.util.HashMap;

public class Task4 {
    private Task4() {

    }

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 3999;

    public static String convertToRoman(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException("Not correct number (1<number<4000)");
        }

        int numberToConvert = number;


        @SuppressWarnings("MagicNumber")
        HashMap<Integer, String> intRoman = new HashMap<Integer, String>() {
            {
                put(1, "I");
                put(4, "IV");
                put(5, "V");
                put(9, "IX");
                put(10, "X");
                put(40, "XL");
                put(50, "L");
                put(90, "XC");
                put(100, "C");
                put(400, "CD");
                put(500, "D");
                put(900, "CM");
                put(1000, "M");
            }};
        @SuppressWarnings("MagicNumber")
        int[] arr = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuilder s = new StringBuilder();

        for (int i : arr) {
            while (numberToConvert >= i) {
                s.append(intRoman.get(i));
                    numberToConvert -= i;
            }
        }

        return s.toString();
    }
}
