package edu.project1;

import java.util.Arrays;

public class Word {
    private final char[] wordToGuess;
    private final int length;
    private final char[] currString;
    private boolean isSolved = false;

    public Word(String word) {
        this.wordToGuess = word.toCharArray();
        this.length = word.length();
        this.currString = "*".repeat(word.length()).toCharArray();
    }

    public boolean isSolved() {
        return isSolved;
    }

    public boolean openLetter(char letter) {
        boolean isLetterOpened = false;

        for (int i = 0; i < this.length; ++i) {
            if (this.wordToGuess[i] == letter) {
                this.currString[i] = letter;
                isLetterOpened = true;
            }
        }

        if (isLetterOpened) {
            this.isSolved = Arrays.equals(this.currString, this.wordToGuess);
        }

        return isLetterOpened;
    }

    @Override
    public String toString() {
        return new String(this.currString);
    }
}
