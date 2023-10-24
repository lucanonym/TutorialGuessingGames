package edu.kit.informatik.game01;

import java.util.Scanner;

public class Application {
    /**
     * Message to introduce the game
     */
    private static final String INITIAL_GUESS = "Guess the right number between 1 and 10";
    /**
     * Message, if the number could not be parsed
     */
    private static final String PARSING_ERROR = "Could not parse %s, your guess is not a valid number.";
    /**
     * The Method start starts an application and runs the game
     */
    public void start() {
        try (Scanner scanner = new Scanner(System.in)) {
            runGame(scanner);
        }
    }
    private void runGame(Scanner scanner) {
        System.out.println(INITIAL_GUESS);
        SimpleGuessingGame game = new SimpleGuessingGame();
        while (game.isRunning()) {
            String input = scanner.nextLine();
            try {
                int number = Integer.parseInt(input);
                game.guess(number);
            } catch (NumberFormatException e) {
                System.out.println(PARSING_ERROR.formatted(input));
            }
            System.out.println(game.getMessage());
        }
    }
}
