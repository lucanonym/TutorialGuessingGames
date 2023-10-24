package edu.kit.informatik.game02;

/**
 * This enum models the possibilities of narrowing an interval
 * @author Luca
 * @version 1.0.0
 */
public enum NarrowingIntervalPossibilities {
    /**
     * HIGHER indicates that the interval needs to be shifted higher
     */
    HIGHER,
    /**
     * LOWER indicates that the interval needs to be shifted lower
     */
    LOWER,
    /**
     * GUESSED indicates that the number has been guessed
     */
    GUESSED
}
