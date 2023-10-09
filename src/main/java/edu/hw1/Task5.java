package edu.hw1;

public class Task5 {
    private Task5() {
    }

    public static boolean isPalindromeDescendant(int value) {
        if (value < 0 || String.valueOf(value).length() % 2 != 0) {
            return false;
        }

        String tmpString = String.valueOf(value);

        while (tmpString.length() >= 2) {
            boolean flag = true;

            for (int i = 0; i < tmpString.length(); i++) {
                if (tmpString.charAt(i) != tmpString.charAt(tmpString.length() - 1 - i)) {
                    flag = false;
                }
            }

            if (flag) {
                return true;
            }

            StringBuilder tmpStringBuilder = new StringBuilder();

            for (int i = 0; i < tmpString.length() - 1; i += 2) {
                tmpStringBuilder.append(tmpString.charAt(i) - '0' + tmpString.charAt(i + 1) - '0');
            }

            tmpString = tmpStringBuilder.toString();
        }

        return false;
    }
}
