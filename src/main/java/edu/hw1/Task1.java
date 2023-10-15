package edu.hw1;

public final class Task1 {

    private static final int SEC_IN_MIN = 60;

    private Task1() {
    }

    public static int minutesToSeconds(String videolength) {
        if (videolength == null) {
            return -1;
        }
        String[] splittedString = videolength.split(":");
        int minutes = Integer.parseInt(splittedString[0]);
        int seconds = Integer.parseInt(splittedString[1]);
        if ((seconds < SEC_IN_MIN) && (seconds >= 0) && (minutes >= 0)) {
            return minutes * SEC_IN_MIN + seconds;
        } else {
            return -1;
        }
    }
}
