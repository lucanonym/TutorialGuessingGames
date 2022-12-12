package edu.kit.informatik.game02;

/**
 * This class models the Application
 * @author Luca
 * @version 1.0.0
 */
public class Application {


    /**
     * Message, if the number has not been guessed
     */
    private final String GUESS_AGAIN = "Is %d the right number?";
    /**
     * Message, if the number has been guessed
     */
    private final String RIGHT_NUMBER = "I guessed that %d is the right number!";
    /**
     * This message is printed to avoid trouble with the first guess
     */
    public static final String INITIAL_GUESS = "Is the right number 50?";

    private Interval interval;

    private int correctGuess = 0;
    private boolean isRunning = true;

    /**
     * Constructor creates a guessing game in the {@link Interval} [0,100]
     */

    public Application() {
        this.interval = new Interval(0, 100);
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
                if (Math.abs(interval.getUpperBound() - interval.getLowerBound()) <= 1) {
                    this.isRunning = false;
                    this.correctGuess = interval.getUpperBound();
                } else {
                    interval.shiftIntervalUp();
                }
                break;
            case LOWER :
                if (Math.abs(interval.getUpperBound() - interval.getLowerBound()) <= 1) {
                    this.isRunning = false;
                    this.correctGuess = interval.getLowerBound();
                } else {
                    interval.shiftIntervalDown();
                }
        }
    }
}