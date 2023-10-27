package edu.project1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.in;

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
    @Test
    @DisplayName("Тест открытия нескольких букв сразу")
    void openingTwoWords() {
        Word word = new Word("fanta");
        word.openLetter('a');
        assertThat(word.toString()).isEqualTo("*a**a");
    }
    @Test
    @DisplayName("Загадываемое слово имеет некорректную длину, меняем слово на другое")
    void wrongWordToGuess() {
        Word word = new Word("");
        assertThat(word.toString()).isNotSameAs("");
    }
}
