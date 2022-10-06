package threads.transportadora;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FilaEntregasLock<T>  implements BaseFilaEntrega<T> {

    private Queue<T> filaEntrega = new LinkedList<T>();
    private int capacidade;
    private Lock lock = new ReentrantLock();
    private Condition naoCheia = lock.newCondition();
    private Condition naoVazia = lock.newCondition();

    public FilaEntregasLock(int capacity) {
        this.capacidade = capacity;
    }

    public void carregar(T element) throws InterruptedException {
        lock.lock();
        try {
            while(filaEntrega.size() == capacidade) {
                naoCheia.await();
            }

            filaEntrega.add(element);
            naoVazia.signal(); // notifyAll() for multiple producer/consumer threads
        } finally {
            lock.unlock();
        }
    }

    public T descarregar() throws InterruptedException {
        lock.lock();
        try {
            while(filaEntrega.isEmpty()) {
                naoVazia.await();
            }

            T item = filaEntrega.remove();
            naoCheia.signal(); //for multiple producer/consumer threads
            return item;
        } finally {
            lock.unlock();
        }
    }
}
