package edu.hw5;

import edu.hw5.Task3.DateParser;
import edu.hw5.Task3.DateWithDashParser;
import edu.hw5.Task3.DateWithSlashParser;
import edu.hw5.Task3.DateWithWordParser;
import edu.hw5.Task3.DaysAgoParser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import java.time.LocalDate;
import java.util.Optional;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task3Test {

    @ParameterizedTest
    @CsvSource({"2020-10-10",
        "2020-12-2",
        "1/3/1976",
        "1/3/20",
        "tomorrow",
        "today",
        "yesterday",
        "1 day ago",
        "2234 days ago"})
    void exampleTest(String date) {
        DateParser dateParser = DateParser.link(
            new DateWithDashParser(),
            new DateWithSlashParser(),
            new DaysAgoParser(),
            new DateWithWordParser()
        );

        Optional<LocalDate> ans = dateParser.parse(date);

        assertThat(ans).isPresent().containsInstanceOf(LocalDate.class);
    }
}
