package threadpool;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MainPagamentoMonitorado {

    public static void main(String[] args) {
        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "50");


        final ExecutorService threadPool = Executors.newScheduledThreadPool(10);

        PagamentoMonitorado pagamentoMonitorado = new PagamentoMonitorado();

        // criar loop de 50 pagamentos

       var faturaList =  IntStream.rangeClosed(1,50)
                .boxed()
                .parallel()
                .map(fatura -> {
                    System.out.println("Name " + Thread.currentThread().getName());
                    return pagamentoMonitorado.pagar(fatura.toString());
                })
                .collect(Collectors.toList());

        faturaList.forEach(System.out::println);


        final List<CompletableFuture<String>> collect = IntStream.rangeClosed(1, 50)
                .boxed()
                .map(fatura -> {
                    final CompletableFuture<String> completableFuture =
                            CompletableFuture.supplyAsync(() -> pagamentoMonitorado.pagar(fatura.toString())
                                    , threadPool);
                    System.out.println("Name " + Thread.currentThread().getName());
                    return completableFuture;
                })
                .collect(Collectors.toList());


        collect.forEach(cf -> cf.join() );


        faturaList.forEach(System.out::println);

        final Future<String> stringFuture = meuMetodoAsync();
    }
    
    public static Future<String> meuMetodoAsync() {
        return null;
    }
}
