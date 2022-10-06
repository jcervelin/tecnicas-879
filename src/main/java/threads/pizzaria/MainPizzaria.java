package threads.pizzaria;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class MainPizzaria {

    public static void main(String[] args) {

        BlockingQueue<String> queue = new ArrayBlockingQueue<>(3);

        // carregar da BlockingQueue put(elemento)
        // descarregar/remover da BlockingQueue take()


        Pizzaria carregador1 = new Pizzaria(queue,"Calabreza");
        Pizzaria carregador2 = new Pizzaria(queue,"Mussarela" );
        Pizzaria carregador3 = new Pizzaria(queue,"Portuguesa" );
        Pizzaria carregador4 = new Pizzaria(queue,"4 Queijos" );
        Pizzaria carregador5 = new Pizzaria(queue,"Havaiana" );

        Entregador entregador1 = new Entregador(queue, 2000);
        Entregador entregador2 = new Entregador(queue, 4000);
        Entregador entregador3 = new Entregador(queue, 6000);
        Entregador entregador4 = new Entregador(queue, 8000);
        Entregador entregador5 = new Entregador(queue, 10000);

        new Thread(carregador1, "Lucas").start();
        new Thread(carregador2, "Bill").start();
        new Thread(carregador3, "Filho do Bill").start();
        new Thread(carregador4, "Cachorro do Bill").start();
        new Thread(carregador5, "Agroboys").start();

        new Thread(entregador1).start();
        new Thread(entregador2, "Papagaio do Bill").start();
        new Thread(entregador3).start();
        new Thread(entregador4,"Elefante do BIll").start();
        new Thread(entregador5,"Gato do Bill" ).start();

    }
}
