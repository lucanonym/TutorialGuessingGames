package edu.kit.informatik.game01;

/**
 * This class models the Application
 * @author Luca
 * @version 1.0.0
 */
public class Application {


    /**
     * Message, if the {@link GuessedNumber} has not been guessed
     */

    private final String NOT_THE_RIGHT_NUMBER = "%d is not the right number, you already guessed %d times!";

    /**
     * Message, if the {@link GuessedNumber} has been guessed
     */
    private final String RIGHT_NUMBER = "%d is the right number. You guessed %d times!";
    /**
     * This is the guessed number, the user has to guess
     */
    private final GuessedNumber guessedNumber;

    private int latestGuess;
    private boolean isRunning = true;

    private int numberOfGuesses = 0;



    public Application() {
        this.guessedNumber = new GuessedNumber();
    }

    /**
     * This method checks, if the application is still running so the {@link GuessedNumber}
     * has not been guessed
     * @return if the application is still running
     */

    public boolean isRunning() {
        return this.isRunning;
    }

    /**
     * This method calls {@link GuessedNumber#guessNumber(int)} to check if the number
     * has been guessed. Note that the {@link Application} is running, if the number has not
     * been guessed correctly.
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
     * @return returns the message mapping to the current game state
     */
    public String getMessage() {
        return isRunning ?
                String.format(NOT_THE_RIGHT_NUMBER, latestGuess, numberOfGuesses)
                : String.format(RIGHT_NUMBER, latestGuess, numberOfGuesses);
    }
}
