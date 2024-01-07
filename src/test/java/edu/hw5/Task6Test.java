package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw5.Task6.substringCheck;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task6Test {
    @Test
    @DisplayName("False тест")
    void falseTest() {
        assertThat(substringCheck("achfdbaabgabacabg","abc")).isEqualTo(false);
    }
    @Test
    @DisplayName("True тест")
    void trueTest() {
        assertThat(substringCheck("achfdbaabgabcabg","abc")).isEqualTo(true);
    }

}
