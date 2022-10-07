package reentrantlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MainReentrantLock {

    public static void main(String[] args) {

        Lock lock = new ReentrantLock();

        final Runnable runnable = () -> {
                lock.lock();
                System.out.println(Thread.currentThread().getName() + " pegou o lock e vai aguargar por 5 segundos");
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    System.out.println(Thread.currentThread().getName() + " liberou o lock");
                    lock.unlock();
                }
        };

        new Thread(runnable, "Joao").start();
        new Thread(runnable, "Maria").start();
    }
}
