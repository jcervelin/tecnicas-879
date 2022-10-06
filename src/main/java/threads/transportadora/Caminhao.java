package threads.transportadora;

import java.util.concurrent.BlockingQueue;

public class Caminhao implements Runnable {

    private BlockingQueue<String> queue;

    private long duracao;

    public Caminhao(BlockingQueue<String> queue, long duracao) {
        this.queue = queue;
        this.duracao = duracao;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(duracao);
            final String carga = queue.take();
            System.out.println(Thread.currentThread().getName() + " Completou o carreto de " + carga);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
