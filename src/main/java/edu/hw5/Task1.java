package edu.hw5;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task1 {
    private static final Pattern SESSION_PATTERN =
        Pattern.compile("(\\d{4}-\\d{2}-\\d{2}, \\d{2}:\\d{2}) - (\\d{4}-\\d{2}-\\d{2}, \\d{2}:\\d{2})");
    private static final DateTimeFormatter SESSION_DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd, HH:mm");

    private Task1() {
    }

    public static String getAverageSessionDuration(List<String> sessions) {
        int countStrings = 0;
        Duration totalDuration = Duration.ZERO;
        for (String session : sessions) {
            Matcher sessionMatcher = SESSION_PATTERN.matcher(session);
            if (sessionMatcher.find()) {
                LocalDateTime startTime = LocalDateTime.parse(sessionMatcher.group(1), SESSION_DATE_FORMATTER);
                LocalDateTime endTime = LocalDateTime.parse(sessionMatcher.group(2), SESSION_DATE_FORMATTER);
                totalDuration = totalDuration.plus(Duration.between(startTime, endTime));
                countStrings++;
            } else {
                throw new IllegalArgumentException("Wrong session date format");
            }
        }
        return totalDuration.dividedBy(countStrings).toString();
    }
}
