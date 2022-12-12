package edu.kit.informatik.game02;




import java.util.Scanner;

/**
 * This class is the main class for game 2
 * @author luca
 * @since 0.1.1
 */

public class Main {

    private static final String PARSING_ERROR = "Could not parse %s, command not known.";
    private static final String ARGUMENT_TO_LOWER_INTERVALL = ">";

    private static final String ARGUMENT_GUESSED_NUMBER = "=";

    private static final String ARGUMENT_TO_HIGHER_INTERVALL = "<";

    private Main() {
        throw new IllegalStateException();

    }

    /**
     * Main-Method which creates the {@link Application} and handles the input
     * @param args
     */

    public static void main(String[] args) {

        Application application = new Application();

        final Scanner scanner = new Scanner(System.in);
        System.out.println(Application.INITIAL_GUESS);

        while(application.isRunning()) {
            /*
             * Try catch block is created to catch eventual errors.
             * If you don't understand it yet, don't worry.
             */
            try {
                String higherLower = scanner.nextLine();
                application.narrowInterval(parseHigherLower(higherLower));
                System.out.println(application.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }


    private static NarrowingIntervalPossibilities parseHigherLower(String input) {
        return switch(input) {
            case ARGUMENT_TO_LOWER_INTERVALL -> NarrowingIntervalPossibilities.LOWER;
            case ARGUMENT_TO_HIGHER_INTERVALL -> NarrowingIntervalPossibilities.HIGHER;
            case ARGUMENT_GUESSED_NUMBER -> NarrowingIntervalPossibilities.GUESSED;
            default -> throw new IllegalArgumentException(String.format(PARSING_ERROR, input));
        };
    }


}
