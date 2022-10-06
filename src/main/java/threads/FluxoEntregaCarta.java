package threads;

public class FluxoEntregaCarta {

    private boolean cartaChegou = false;

    public void lerCarta() {
        synchronized (this) {
            while (!cartaChegou) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        System.out.println("Carta Chegou!!!!!");
        System.out.println("Ahh.... era boleto pra pagar.... :(");
    }

    public void sairParaEntrega() {
        synchronized (this) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            this.cartaChegou = true;
            notify();
        }
    }

}
