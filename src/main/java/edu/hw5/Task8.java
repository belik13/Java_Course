package edu.hw5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task8 {
    private Task8() {

    }

    public static boolean isLengthOdd(String string) {
        Pattern pattern = Pattern.compile("^[01]([01]{2})*$");
        Matcher matcher = pattern.matcher(string);

        return matcher.matches();
    }

    public static boolean isNumberOfNullDivisibleByThree(String string) {
        Pattern pattern = Pattern.compile("^1*|(1*01*01*01*)*$");
        Matcher matcher = pattern.matcher(string);

        return matcher.matches();
    }

    public static boolean isStringWithout11or111(String string) {
        Pattern pattern = Pattern.compile("(?!11$|111$)[01]*");
        Matcher matcher = pattern.matcher(string);

        return matcher.matches();
    }

    public static boolean ifAllOddSymbolsAre1(String string) {
        Pattern pattern = Pattern.compile("^1(0$|1$|(01)|(11)$)*$");
        Matcher matcher = pattern.matcher(string);

        return matcher.matches();
    }
}
