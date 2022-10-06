package threads.pizzaria;

import java.util.concurrent.BlockingQueue;

public class Entregador implements Runnable {

    private final BlockingQueue<String> queque;

    private final long time;

    public Entregador(BlockingQueue<String> queque, long time) {
        this.queque = queque;
        this.time = time;
    }

    @Override
    public void run() {
        // ter tempo de entrega
        // e vai ter que completar (descarregar)

        try {
            Thread.sleep(time);
            String carga = queque.take();
            System.out.println("Completou a entrega " + Thread.currentThread().getName() + carga);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}