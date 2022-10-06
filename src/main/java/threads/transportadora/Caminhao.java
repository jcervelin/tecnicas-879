package threads.transportadora;

public class Caminhao implements Runnable {

    private BaseFilaEntrega<String> queue;

    private long duracao;

    public Caminhao(BaseFilaEntrega<String> queue, long duracao) {
        this.queue = queue;
        this.duracao = duracao;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(duracao);
            final String carga = queue.descarregar();
            System.out.println(Thread.currentThread().getName() + " Completou o carreto de " + carga);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
