package streams;

public class MainTesteThread {

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

        new Thread(run,"Bruno").start();
        new Thread(run,"Ingrid").start();
    }
}
