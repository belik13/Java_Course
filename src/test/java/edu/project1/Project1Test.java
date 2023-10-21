package edu.project1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Project1Test {
    @Test
    @DisplayName("Тест на победу")
    void winTest() {
        ConsoleHangman game = new ConsoleHangman(2, new Word("check"));
        String wordState;

        assertThat(game.guessLetter('e')).isTrue();

        wordState = game.getCurrWordString();
        assertThat(wordState).isEqualTo("**e**");

        game.guessLetter('c');
        wordState = game.getCurrWordString();
        assertThat(wordState).isEqualTo("c*ec*");

        game.guessLetter('h');
        wordState = game.getCurrWordString();
        assertThat(wordState).isEqualTo("chec*");
        game.guessLetter('k');
        assertThat(game.win()).isEqualTo(true);
    }
    @Test
    @DisplayName("Тест на поражение")
    void loseTest() {
        ConsoleHangman game = new ConsoleHangman(2, new Word("check"));
        String wordState;

        game.guessLetter('f');
        game.guessLetter('f');

        assertThat(game.lose()).isEqualTo(true);
    }

}
