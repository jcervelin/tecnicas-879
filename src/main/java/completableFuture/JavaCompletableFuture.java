package completableFuture;

import threadpool.PagamentoMonitorado;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class JavaCompletableFuture {
    public static void main(String[] args) {
        // dado que cada pagamento demora 2 segundos
        // executar 100 pagamentos em 10 segundos
        // usar classe threadpool.PagamentoMonitorado

        var inicio = System.currentTimeMillis();

        PagamentoMonitorado pagamentoMonitorado = new PagamentoMonitorado();
        Executor executor = Executors.newFixedThreadPool(20);

        final List<CompletableFuture<String>> faturaFuture = IntStream.rangeClosed(1, 100)
                .boxed()
                .map(i -> CompletableFuture.supplyAsync(() -> pagamentoMonitorado.pagar(i.toString()), executor))
                .collect(Collectors.toList());

        final List<String> faturas = faturaFuture.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());

        var fim = System.currentTimeMillis();

        System.out.println((fim - inicio) / 1000);
    }
}
