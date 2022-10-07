package threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainThreadPool {

    public static void main(String[] args) {
        final ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 10; i++) {
            executorService.execute(new Pagamento());
        }
        System.out.println("fim do processo. So que nao");

        executorService.shutdownNow();
    }
}
