import java.util.concurrent.ExecutorService;

public class Main {
    public static void main(String[] args) {

        ExecutorService pool = ThreadPoolManager.getInstance().getExecutor();

        pool.submit(() -> {
            System.out.println("Task running in shared pool");
        });
    }
}
