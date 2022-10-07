package threadpool;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Pagamento implements Runnable {
    public void pagar() {
        try {
            final int i = new Random().nextInt(5);

            TimeUnit.SECONDS.sleep(i);
            System.out.println(System.nanoTime() + " : Pagou!!!");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        pagar();
    }
}
