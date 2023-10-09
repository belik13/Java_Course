package edu.hw1;

public class Task4 {
    private Task4() {
    }

    public static String fixString(String toFix) {
        if (toFix == null || toFix.isEmpty()) {
            return "";
        }

        StringBuilder fixed = new StringBuilder();

        for (int i = 0; i < toFix.length() - 1; i += 2) {
            fixed.append(toFix.charAt(i + 1));
            fixed.append(toFix.charAt(i));
        }

        if (toFix.length() % 2 != 0) {
            fixed.append(toFix.charAt(toFix.length() - 1));
        }

        return fixed.toString();
    }
}
