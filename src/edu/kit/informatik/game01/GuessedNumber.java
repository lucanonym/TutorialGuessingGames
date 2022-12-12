package edu.kit.informatik.game01;

/**
 * This models the guessed Number of the computer in a range between 1-10
 */
public class GuessedNumber {
    /**
     * Constant 10 to create a {@link GuessedNumber} in the range between 1-10
     */
    private final int RANDOM_FACTOR = 10;
    private final int guessedNumber;

    public GuessedNumber() {
        this.guessedNumber = (int) (Math.random() * RANDOM_FACTOR);
    }

    /**
     * True, if the number has been guessed
     * @param number which has been guessed
     * @return true, if the number has been guessed
     */
    public boolean guessNumber(int number) {
        return this.guessedNumber == number;
    }
}
