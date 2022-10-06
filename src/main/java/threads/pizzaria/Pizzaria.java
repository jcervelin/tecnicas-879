package threads.pizzaria;

import java.util.concurrent.BlockingQueue;

public class Pizzaria implements Runnable {

    private final BlockingQueue<String> filaEntrega;
    private final String pizza;

    public Pizzaria(BlockingQueue<String> filaEntrega, String pizza) {
        this.filaEntrega = filaEntrega;
        this.pizza = pizza;
    }

    @Override
    public void run() {

        try{
            filaEntrega.put(pizza);
            System.out.println(Thread.currentThread().getName() + " Entregou ao pizza a " + pizza );
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
