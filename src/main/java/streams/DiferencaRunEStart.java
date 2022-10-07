package streams;

public class DiferencaRunEStart {

    public static void main(String[] args) {

        System.out.println("Corrida das threads");

        Runnable run = () -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + " chegou!");
        };

        final Thread thread = new Thread(run, "Cristiano");
        thread.start();
        System.out.println("Depois do Cristiano");
        // assincrono nesta linha eu chamei um servico que demora 10 segundos
        new Thread(run,"Bruno").start();
        System.out.println("Depois do Bruno");
        new Thread(run,"Ingrid").start();
        System.out.println("Depois da Ingrid");

    }
}
