package edu.hw5.Task3;

import java.time.LocalDate;
import java.util.Optional;

public class DateWithWordParser extends DateParser {
    @Override
    public Optional<LocalDate> parse(String date) {
        try {
            return Optional.of(parseDateWithWord(date));
        } catch (Exception e) {
            return parseNext(date);
        }
    }

    public LocalDate parseDateWithWord(String date) {
        return switch (date) {
            case "yesterday" -> LocalDate.now().minusDays(1);
            case "tomorrow" -> LocalDate.now().plusDays(1);
            case "today" -> LocalDate.now();
            default -> throw new IllegalArgumentException();
        };
    }
}
