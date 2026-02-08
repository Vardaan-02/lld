import java.util.concurrent.ExecutorService;

public class Main {
    public static void main(String[] args) {

        ExecutorService pool = ThreadPoolManager.getInstance().getExecutor();
        Logger logger = Logger.getInstance();

        logger.info("Application started");
        
        pool.submit(() -> {
            System.out.println("Task running in shared pool");
        });

        logger.error("Something failed");

        pool.shutdown(); 
    }
}
