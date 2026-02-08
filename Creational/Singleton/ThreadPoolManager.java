import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolManager {

    private final ExecutorService executor;

    private ThreadPoolManager() {
        executor = Executors.newFixedThreadPool(10);
    }

    // Bill Pugh Method
    private static class Holder {
        private static final ThreadPoolManager INSTANCE = new ThreadPoolManager();
    }

    public static ThreadPoolManager getInstance() {
        return Holder.INSTANCE;
    }

    public ExecutorService getExecutor() {
        return executor;
    }

    public void shutdown() {
        executor.shutdown();
    }
}
