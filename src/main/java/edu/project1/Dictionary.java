package edu.project1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Dictionary {
    private Dictionary() {

    }

    private static final ArrayList<String> WORDS = new ArrayList<String>(List.of(
        "book",
        "magazine",
        "banana",
        "starship",
        "kilobyte"
    ));
    private static final Random RANDOMIZER = new Random();

    public static Word getRandomWord() {
        return new Word(WORDS.get(RANDOMIZER.nextInt(WORDS.size())));
    }
}
