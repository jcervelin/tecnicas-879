package threads.transportadora;

import java.util.concurrent.BlockingQueue;

public class Carregador implements Runnable {

    private BlockingQueue<String> filaEntrega;
    private String carga;

    public Carregador(BlockingQueue<String> filaEntrega, String carga) {
        this.filaEntrega = filaEntrega;
        this.carga = carga;
    }

    @Override
    public void run() {
        try {
            filaEntrega.put(carga);
            System.out.println(Thread.currentThread().getName() + " carregou um caminhao com " + carga);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
