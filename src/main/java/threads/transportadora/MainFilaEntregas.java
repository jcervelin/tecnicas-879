package threads.transportadora;

public class MainFilaEntregas {

    public static void main(String[] args)  {

        BaseFilaEntrega<String> fila = new FilaEntregas<>(3);

        Carregador carregador1 = new Carregador(fila,"Arroz" );
        Carregador carregador2 = new Carregador(fila,"Feijao" );
        Carregador carregador3 = new Carregador(fila,"Abobrinha" );
        Carregador carregador4 = new Carregador(fila,"Beterraba" );
        Carregador carregador5 = new Carregador(fila,"Cebola" );
        Carregador carregador6 = new Carregador(fila,"Coentro" );

        Caminhao caminhaoArroz = new Caminhao(fila,2000);
        Caminhao caminhaoFeijao = new Caminhao(fila,4000);
        Caminhao caminhaoAbobrinha = new Caminhao(fila, 6000);
        Caminhao caminhaoBeterraba = new Caminhao(fila, 8000);
        Caminhao caminhaoCebola = new Caminhao(fila, 10000);
        Caminhao caminhaoCoentro = new Caminhao(fila, 12000);

        final Thread arthur = new Thread(caminhaoArroz, "Arthur");
        final Thread sogolon = new Thread(caminhaoFeijao, "Sogolon");
        final Thread victoria = new Thread(caminhaoAbobrinha, "Victoria");
        final Thread anaLuisa = new Thread(caminhaoBeterraba, "Ana Luisa");
        final Thread victor = new Thread(caminhaoCebola, "Victor");
        final Thread lucas = new Thread(caminhaoCoentro, "Lucas");

        final Thread a = new Thread(carregador1, "A");
        final Thread b = new Thread(carregador2, "B");
        final Thread c = new Thread(carregador3, "C");
        final Thread d = new Thread(carregador4, "D");
        final Thread e = new Thread(carregador5, "E");
        final Thread f = new Thread(carregador6, "F");

        arthur.start();
        sogolon.start();
        victoria.start();
        anaLuisa.start();
        victor.start();
        lucas.start();

        a.start();
        b.start();
        c.start();
        d.start();
        e.start();
        f.start();
    }
}
