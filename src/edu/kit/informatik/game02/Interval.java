package edu.kit.informatik.game02;

/**
 * This class models an interval
 * @author luca
 * @since 0.0.1
 */
public class Interval {
    /**
     * This is the maximum of the interval which can't be overpassed
     */
    private final int HARD_UPPER_BOUND;
    /**
     * This is the minimum of the interval which can't be overpassed
     */
    private final int HARD_LOWER_BOUND;
    private int upperBound;
    private int lowerBound;

    private int middle;

    /**
     * Constructs a new Interval.
     * @param lowerBound lower Bound of the constructed Interval
     * @param upperBound upper bound of the constructed Interval
     */
    public Interval(int lowerBound, int upperBound) {
        this.HARD_LOWER_BOUND = lowerBound;
        this.HARD_UPPER_BOUND = upperBound;
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
        this.middle = upperBound / 2;
    }

    /**
     * This method shifts an {@link Interval} up
     */
    public void shiftIntervalUp() {
        this.lowerBound = middle + 1;
        this.middle = lowerBound + (upperBound - lowerBound) / 2;

        /*
         This asserts that the interval doesn't cross it's borders
         */

        assert(this.lowerBound >= HARD_LOWER_BOUND
                && this.upperBound <= HARD_UPPER_BOUND
                && this.middle <= HARD_UPPER_BOUND
                && this.middle >= HARD_LOWER_BOUND);
    }

    /**
     * This method shifts an {@link Interval} up
     */

    public void shiftIntervalDown() {
        this.upperBound = middle - 1;
        this.middle = lowerBound + (upperBound - lowerBound) / 2;

        /*
         his asserts that the interval doesn't cross it's borders
         */

        assert(lowerBound >= HARD_LOWER_BOUND
                && upperBound <= HARD_UPPER_BOUND
                && middle <= HARD_UPPER_BOUND
                && middle >= HARD_LOWER_BOUND);
    }

    /**
     * This method gets the upper Bound
     * @return integer value of the upper bound
     */
    public int getUpperBound() {
        return this.upperBound;
    }

    /**
     * This method gets the upper Bound
     * @return integer value of the lower bound
     */
    public int getLowerBound() {
        return this.lowerBound;
    }

    /**
     * This method gets the middle.
     * @return middle of the interval.
     */
    public int getMiddle() {
        return middle;
    }
}
