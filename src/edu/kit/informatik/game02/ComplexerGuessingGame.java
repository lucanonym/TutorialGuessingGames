package edu.kit.informatik.game02;

/**
 * This class models the ComplexerGuessingGame, which is a game where the user selects a number in range (0, 100)
 * and the computer guesses it. The user can only answer with higher, lower or guessed.
 * @author luca
 * @version 1.0.0
 */
public class ComplexerGuessingGame {
    /**
     * Message, if the number has not been guessed
     */
    private static final String GUESS_AGAIN = "Is %d the right number?";
    /**
     * Message, if the number has been guessed
     */
    private static final String RIGHT_NUMBER = "The number has to be %d!";
    /**
     * This is the interval which is used to narrow down the possibilities
     */
    private final Interval interval;
    /**
     * This is the number which has been guessed
     */
    private int correctGuess = 0;
    /**
     * This boolean indicates, if the application is still running
     */
    private boolean isRunning = true;
    /**
     * This constructor initializes the {@link Interval #interval} with the default values of 0 and 100
     */
    public ComplexerGuessingGame() {
        this.interval = new Interval(0, 100);
    }
    /**
     * This method returns the accurate message, of the latest guess. Has to be called
     * only after {@link #narrowInterval(NarrowingIntervalPossibilities)}
     * @return returns the message mapping to the current game state
     */
    public String getMessage() {
        return isRunning ?
                String.format(GUESS_AGAIN,  interval.getMiddle())
                : String.format(RIGHT_NUMBER, correctGuess);
    }
    /**
     * This method checks, if the application is still running so the {@link #correctGuess}
     * has not been found
     * @return if the application is still running
     */
    public boolean isRunning() {
        return this.isRunning;
    }
    /**
     * This method is used to shift {@link Interval #interval} to the corresponding borders
     * @param shiftDirection direction which the interval should be shifted
     */
    public void narrowInterval(NarrowingIntervalPossibilities shiftDirection) {
        switch(shiftDirection) {
            case GUESSED :
                this.correctGuess = interval.getMiddle();
                isRunning = false;
                break;
            case HIGHER :
                shiftHigher();
                break;
            case LOWER :
                shiftLower();
                break;
        }
    }
    /**
     * This method shifts the interval to the lower bound
     */
    private void shiftLower() {
        if (Math.abs(interval.getUpperBound() - interval.getLowerBound()) <= 1) {
            this.isRunning = false;
            this.correctGuess = interval.getLowerBound();
        } else {
            interval.shiftIntervalDown();
        }
    }
    /**
     * This method shifts the interval to the upper bound
     */
    private void shiftHigher() {
        if (Math.abs(interval.getUpperBound() - interval.getLowerBound()) <= 1) {
            this.isRunning = false;
            this.correctGuess = interval.getUpperBound();
        } else {
            interval.shiftIntervalUp();
        }
    }
}
