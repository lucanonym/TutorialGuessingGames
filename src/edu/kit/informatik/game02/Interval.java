package edu.kit.informatik.game02;

/**
 * This class models a bounded Interval with upper and lower bound.
 * @author luca
 * @since 1.0.0
 */
public class Interval {
    /**
     * This is the upper bound of the current interval
     */
    private int upperBound;
    /**
     * This is the lower bound of the current interval
     */
    private int lowerBound;
    /**
     * This is the middle of the current interval
     */
    private int middle;
    /**
     * Constructs a new Interval.
     * @param lowerBound lower Bound of the constructed Interval
     * @param upperBound upper bound of the constructed Interval
     */
    public Interval(int lowerBound, int upperBound) {
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

    }
    /**
     * This method shifts an {@link Interval} down
     */
    public void shiftIntervalDown() {
        this.upperBound = middle - 1;
        this.middle = lowerBound + (upperBound - lowerBound) / 2;
    }
    /**
     * This method gets the {@link Interval#upperBound} of the {@link Interval}.
     * @return integer value of the upper bound
     */
    public int getUpperBound() {
        return this.upperBound;
    }
    /**
     * This method gets the {@link Interval#lowerBound} of the {@link Interval} .
     * @return integer value of the lower bound
     */
    public int getLowerBound() {
        return this.lowerBound;
    }
    /**
     * This method gets the {@link Interval#middle} of the {@link Interval}.
     * @return middle of the interval.
     */
    public int getMiddle() {
        return middle;
    }
}
