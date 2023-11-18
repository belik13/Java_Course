package edu.hw5.Task3;

import java.time.LocalDate;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class DaysAgoParser extends DateParser {
    private static final Pattern DATE = Pattern.compile("^(\\d+)\\s+day[s]?\\s+ago$");

    @Override
    public Optional<LocalDate> parse(String date) {
        try {
            return Optional.of(parseDate(date));
        } catch (Exception e) {
            return parseNext(date);
        }
    }

    public LocalDate parseDate(String date) {
        int days = parseDays(date);

        return LocalDate.now().minusDays(days);
    }

    public int parseDays(String date) {
        Matcher matcher = DATE.matcher(date);

        if (matcher.find()) {
            return Integer.parseInt(matcher.group(1));
        } else {
            throw new IllegalArgumentException();
        }
    }
}
