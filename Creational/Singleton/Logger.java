import java.time.LocalDateTime;

public class Logger {

    private Logger() {}

    private static class Holder {
        private static final Logger INSTANCE = new Logger();
    }

    public static Logger getInstance() {
        return Holder.INSTANCE;
    }

    public void info(String message) {
        System.out.println(
            "[INFO] " + LocalDateTime.now() + " : " + message
        );
    }

    public void error(String message) {
        System.err.println(
            "[ERROR] " + LocalDateTime.now() + " : " + message
        );
    }
}
