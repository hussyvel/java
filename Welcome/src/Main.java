import java.util.logging.Logger;

public final class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    private static final String WELCOME_MESSAGE = "Welcome to the Java Programming!";

    private Main(){
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static void main(String[] args) {
        LOGGER.severe(WELCOME_MESSAGE);
    }
}