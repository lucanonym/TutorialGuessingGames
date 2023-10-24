package edu.kit.informatik.game01;


/**
 * This class is the main class for game 1
 * @author luca
 * @since 0.1.1
 */


public class Main {
    private Main() {

        throw new IllegalStateException();

    }
    /**
     * This method starts the application
     * @param args optional arguments for the application
     */
    public static void main(String[] args) {
        Application application = new Application();
        application.start();
    }
}
