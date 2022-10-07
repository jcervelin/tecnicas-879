package threadpool;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class PagamentoMonitorado {

    public String pagar(String fatura) {
        try {
            TimeUnit.SECONDS.sleep(2);
            System.out.println(System.currentTimeMillis() + ": Fatura " + fatura + " paga");
            return fatura + " - " + UUID.randomUUID();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
