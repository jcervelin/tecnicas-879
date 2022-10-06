package threads;

public class MainFluxoDeEntregaCarta {

    public static void main(String[] args) {

        FluxoEntregaCarta fluxo = new FluxoEntregaCarta();

        Runnable run1 = () -> {
            System.out.println("Quero ler minha carta");
            // ler carta
            fluxo.lerCarta();
        };

        new Thread(run1).start();

        Runnable run2 = () -> {
            System.out.println("Carteiro saindo para entrega");
            // sair para entregar carta
            fluxo.sairParaEntrega();
        };

        new Thread(run2).start();

    }
}
