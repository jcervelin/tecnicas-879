package threads.transportadora;

import java.util.LinkedList;
import java.util.Queue;

public class FilaEntregas<T> implements BaseFilaEntrega<T> {

    private Queue<T> filaEntrega = new LinkedList<>();
    private int capacidade;

    public FilaEntregas(int capacity) {
        this.capacidade = capacity;
    }

    public synchronized void carregar(T element) throws InterruptedException {
        while(filaEntrega.size() == capacidade) {
            wait();
        }

        filaEntrega.add(element);
        notify(); // notifyAll() for multiple producer/consumer threads
    }

    public synchronized T descarregar() throws InterruptedException {
        while(filaEntrega.isEmpty()) {
            wait();
        }

        T item = filaEntrega.remove();
        notifyAll(); //for multiple producer/consumer threads
        return item;
    }
}
