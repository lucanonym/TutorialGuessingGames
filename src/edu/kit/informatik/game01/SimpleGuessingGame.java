package edu.kit.informatik.game01;

/**
 * This class models the Application
 * @author Luca
 * @version 1.0.0
 */
public class SimpleGuessingGame {

    /**
     * Message, if the {@link RandomNumber} has not been guessed
     */
    private static final String NOT_THE_RIGHT_NUMBER = "%d is not the right number, you already guessed %d times!";

    /**
     * Message, if the {@link RandomNumber} has been guessed
     */
    private static final String RIGHT_NUMBER = "%d is the right number. You guessed %d times!";
    /**
     * This is the guessed number, the user has to guess
     */
    private final RandomNumber guessedNumber;
    /**
     * This is the latest guess
     */
    private int latestGuess;
    /**
     * This boolean indicates, if the application is still running
     */
    private boolean isRunning = true;
    /**
     * This is the number of guesses the user has made
     */
    private int numberOfGuesses = 0;


    public SimpleGuessingGame() {
        this.guessedNumber = new RandomNumber();
    }

    /**
     * This method checks, if the application is still running so the {@link RandomNumber}
     * has not been guessed
     *
     * @return if the application is still running
     */

    public boolean isRunning() {
        return this.isRunning;
    }

    /**
     * This method calls {@link RandomNumber#guessNumber(int)} to check if the number
     * has been guessed. Note that the {@link SimpleGuessingGame} is running, if the number has not
     * been guessed correctly.
     *
     * @param number which has been guessed
     */
    public void guess(int number) {
        numberOfGuesses++;
        this.latestGuess = number;
        isRunning = !guessedNumber.guessNumber(number);
    }

    /**
     * This method returns the accurate message, of the latest guess. Has to be called
     * only after {@link #guess(int)}
     *
     * @return returns the message mapping to the current game state
     */
    public String getMessage() {
        return isRunning ?
                String.format(NOT_THE_RIGHT_NUMBER, latestGuess, numberOfGuesses)
                : String.format(RIGHT_NUMBER, latestGuess, numberOfGuesses);
    }
}

