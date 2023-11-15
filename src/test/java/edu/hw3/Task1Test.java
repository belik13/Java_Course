package edu.hw3;


import edu.hw1.Task5;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static edu.hw3.Task1.atbash;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task1Test {
    @ParameterizedTest
    @DisplayName("Default cases")
    @CsvSource({"FDSfifdskfjb, UWHuruwhpuqy", "abc, zyx", "uwhuhwsstust, fdsfsdhhgfhg"})
    void ParametrizedTest(String input, String excepted) {
        String ans = atbash(input);

        assertThat(ans).isEqualTo(excepted);
    }
    @Test
    @DisplayName("Example Test")
    void ExampleTest() {
        String ans = atbash("Any fool can write code that a computer can understand. Good programmers write code that humans can understand. ― Martin Fowler");

        assertThat(ans).isEqualTo("Zmb ullo xzm dirgv xlwv gszg z xlnkfgvi xzm fmwvihgzmw. Tllw kiltiznnvih dirgv xlwv gszg sfnzmh xzm fmwvihgzmw. ― Nzigrm Uldovi");
    }
    @Test
    @DisplayName("Empty input")
    void EmptyInput() {
        String ans = atbash("");
        assertThat(ans).isEqualTo("");
    }
}
