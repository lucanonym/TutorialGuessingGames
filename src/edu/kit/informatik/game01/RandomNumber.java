package edu.kit.informatik.game01;

import java.util.Random;

/**
 * This models the random number of the computer in a range between 1-10
 * @author Luca
 * @version 1.0.0
 **/
public class RandomNumber {
    /**
     * Constant 10 to create a {@link RandomNumber} in the range between 1-10
     */
    private static final int RANDOM_BOUND = 10;
    /**
     * The random number that has been generated
     */
    private final int guessedNumber;
    /**
     * Constructs a new {@link RandomNumber} by using the {@link Random}
     * class with the {@link Random#nextInt(int)} method.
     * The upper bound is given by the constant {@link RandomNumber#RANDOM_BOUND}
     */
    public RandomNumber() {
        Random random = new Random();
        this.guessedNumber = random.nextInt(RANDOM_BOUND);
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
