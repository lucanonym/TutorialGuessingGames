package edu.kit.informatik.game01;



import java.util.Scanner;

/**
 * This class is the main class for game 1
 * @author luca
 * @since 0.1.1
 */


public class Main {

    private Main() {

        throw new IllegalStateException();

    }

    public static void main(String[] args) {

        Application application = new Application();

        final Scanner scanner = new Scanner(System.in);

        while (application.isRunning()) {
            /*
             * Try catch block is created to catch eventual errors.
             * If you don't understand it yet, don't worry.
             */
            try {
                int guess = scanner.nextInt();
                application.guess(guess);
                System.out.println(application.getMessage());
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
    }
}