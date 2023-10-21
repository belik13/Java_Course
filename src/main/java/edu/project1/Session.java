package edu.project1;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


class Session {
    private static final Logger LOGGER = LogManager.getLogger();
    private final static Scanner SCANNER = new Scanner(System.in);
    private final static int MAX_ATTEMPTS = 5;
    private static String input;

    private Session() {

    }

    public static void startGame() {
        ConsoleHangman game = new ConsoleHangman(MAX_ATTEMPTS, Dictionary.getRandomWord());

        while (!game.lose() && !game.win()) {
            LOGGER.info("Guess a letter:");

            input = SCANNER.nextLine();

            if (input.length() != 1) {
                LOGGER.info("Enter just 1 letter");
                continue;
            }

            game.guessLetter(input.charAt(0));
            LOGGER.info("Current Word:" + game.getCurrWordString());

            if (game.win()) {
                LOGGER.info("Congratulations! You win!");
            }
            if (game.lose()) {
                LOGGER.info("You lost :(((");
            }
        }
    }
}


