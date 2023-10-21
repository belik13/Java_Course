package edu.project1;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

class ConsoleHangman {
    private int currAttempts;
    private final int maxAttempts;
    private final Word wordToGuess;
    public String message;

    private static final Logger LOGGER = LogManager.getLogger();
    private final static Scanner SCANNER = new Scanner(System.in);

    ConsoleHangman(int currAttempts, int maxAttempts, Word wordToGuess) {
        this.currAttempts = currAttempts;
        this.maxAttempts = maxAttempts;
        this.wordToGuess = wordToGuess;
    }

    ConsoleHangman(int maxAttempts, Word wordToGuess) {
        this.currAttempts = currAttempts;
        this.maxAttempts = maxAttempts;
        this.wordToGuess = wordToGuess;
    }

    public Word getWordToGuess() {
        return this.wordToGuess;
    }

    public Word getCurrWord() {
        return this.getCurrWord();
    }

    public String getCurrWordString() {
        return this.wordToGuess.toString();
    }

    public boolean guessLetter(char letter) {
        if (!this.wordToGuess.openLetter(letter)) {
            this.currAttempts++;
        }
        LOGGER.info("Mistake " + (this.currAttempts)
            + " of " + this.maxAttempts);
        return this.currAttempts < this.maxAttempts;
    }

    public boolean lose() {
        return this.currAttempts == this.maxAttempts;
    }

    public boolean win() {
        return this.wordToGuess.isSolved();
    }
}
