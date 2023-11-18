package edu.hw5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task7 {
    private Task7() {

    }

//    public static void main(String[] args) {
//        System.out.println(secPattern("0101010101"));
//    }
    public static boolean firstPattern(String string) {
        Pattern pattern = Pattern.compile("^[01]{2}0.*$");
        Matcher matcher = pattern.matcher(string);

        return matcher.matches();
    }

    public static boolean secPattern(String string) {
        Pattern pattern = Pattern.compile("^|1|0|0.*0$|^1.*1$");
        Matcher matcher = pattern.matcher(string);

        return matcher.matches();
    }

    public static boolean thirdPattern(String string) {
        Pattern pattern = Pattern.compile("^[01]{1,3}$");
        Matcher matcher = pattern.matcher(string);

        return matcher.matches();
    }
}
