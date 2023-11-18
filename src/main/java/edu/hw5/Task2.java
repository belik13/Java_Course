package edu.hw5;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

public class Task2 {
    private final static int FRIDAY_DAY = 13;

    private Task2() {

    }

    //    public static void main(String[] args) {
//        System.out.println(findFridays(2024));
//        System.out.println(findNextFriday(LocalDate.parse("2024-12-12")));
//    }
    public static List<LocalDate> findFridays(int year) {
        List<LocalDate> fridays = new ArrayList<>();

        LocalDate localDate = LocalDate.of(year, Month.JANUARY, 1);

        while (localDate.getYear() == year) {
            if (localDate.getDayOfWeek() == DayOfWeek.FRIDAY && localDate.getDayOfMonth() == FRIDAY_DAY) {
                fridays.add(localDate);
            }

            localDate = localDate.plusDays(1);
        }

        return fridays;
    }

    public static LocalDate findNextFriday(LocalDate localDate) {
        LocalDate friday = localDate.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));

        while (friday.getDayOfMonth() != FRIDAY_DAY) {
            friday = localDate.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
        }

        return friday;
    }
}
