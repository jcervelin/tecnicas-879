package threads.transportadora;

public class Carregador implements Runnable {

    private BaseFilaEntrega<String> filaEntrega;
    private String carga;

    public Carregador(BaseFilaEntrega<String> filaEntrega, String carga) {
        this.filaEntrega = filaEntrega;
        this.carga = carga;
    }

    @Override
    public void run() {
        try {
            filaEntrega.carregar(carga);
            System.out.println(Thread.currentThread().getName() + " carregou um caminhao com " + carga);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
