package edu.kit.informatik.game02;

import java.util.Scanner;

/**
 * This class models the Application
 * @author Luca
 * @version 1.0.0
 */
public class App {
    /**
     * This message is printed to avoid trouble with the first guess
     **/
    public static final String INITIAL_GUESS = "Is the right number 50?";
    /**
     * This message is printed, if the input could not be parsed
     */
    public static final String PARSING_ERROR = "Could not parse %s, command not known.";
    /**
     * This is the argument which has to be passed to the program to indicate that the guessed number is lower
     */
    public static final String ARGUMENT_TO_LOWER_INTERVAL = "<";
    /**
     * This is the argument which has to be passed to the program to indicate that the guessed number is correct
     */
    public static final String ARGUMENT_GUESSED_NUMBER = "=";
    /**
     * This is the argument which has to be passed to the program to indicate that the guessed number is higher
     */
    public static final String ARGUMENT_TO_HIGHER_INTERVAL = ">";

    /**
     * This method starts the application
     */
    public void start() {
        System.out.println(INITIAL_GUESS);
        try(Scanner scanner = new Scanner(System.in)) {
            runGame(scanner);
        }
    }
    /**
     * This method runs a {@link ComplexerGuessingGame}
     * @param scanner the scanner which is used to read the input
     */
    public void runGame(Scanner scanner) {
        ComplexerGuessingGame game = new ComplexerGuessingGame();
        while(game.isRunning()) {
            game.narrowInterval(parseHigherLower(scanner.next()));
            System.out.println(game.getMessage());
        }
    }
    /**
     * This method parses the input to the corresponding {@link NarrowingIntervalPossibilities}
     * @param input the input which has to be parsed
     * @return the corresponding {@link NarrowingIntervalPossibilities}
     */
    private static NarrowingIntervalPossibilities parseHigherLower(String input) {
        return switch(input) {
            case ARGUMENT_TO_LOWER_INTERVAL -> NarrowingIntervalPossibilities.LOWER;
            case ARGUMENT_TO_HIGHER_INTERVAL -> NarrowingIntervalPossibilities.HIGHER;
            case ARGUMENT_GUESSED_NUMBER -> NarrowingIntervalPossibilities.GUESSED;
            default -> throw new IllegalArgumentException(String.format(PARSING_ERROR, input));
        };
    }
}
