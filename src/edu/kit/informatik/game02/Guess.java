package edu.kit.informatik.game02;

/**
 * This class models a guess,
 * which is a number and a boolean, which indicates, if the number has been guessed by the player
 * @author luca
 * @version 1.0.0
 */
public record Guess(boolean hasBeenGuessed, int guess) {
}
