package edu.kit.informatik.game02;

/**
 * This class is the main class for game 2
 * @author luca
 * @since 0.1.1
 */
public class Main {
    private Main() {
        throw new IllegalStateException();
    }
    /**
     * Main-Method which creates the {@link App}
     * @param args optional arguments, that the App can use
     */
    public static void main(String[] args) {
        App app = new App();
        app.start();
    }
}
