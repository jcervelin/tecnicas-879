package threads.transportadora;

public interface BaseFilaEntrega<T> {
    void carregar(T element) throws InterruptedException;
    T descarregar() throws InterruptedException;
}
