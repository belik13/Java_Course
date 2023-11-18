package edu.hw5.Task3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class DateWithSlashParser extends DateParser {
    @Override
    public Optional<LocalDate> parse(String date) {
        try {
            return Optional.of(parseDateWithDash(date));
        } catch (Exception e) {
            return parseNext(date);
        }
    }

    public LocalDate parseDateWithDash(String date) {
        return LocalDate.parse(date, DateTimeFormatter.ofPattern("d/M/y"));
    }
}
