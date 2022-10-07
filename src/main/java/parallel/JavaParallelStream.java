package parallel;

import threadpool.PagamentoMonitorado;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class JavaParallelStream {
    public static void main(String[] args) {
        // dado que cada pagamento demora 2 segundos
        // executar 100 pagamentos em 10 segundos
        // usar classe threadpool.PagamentoMonitorado
        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "20");
        PagamentoMonitorado pagamentoMonitorado = new PagamentoMonitorado();

        var faturaList = IntStream.rangeClosed(1,100)
                .boxed()
                .parallel()
                .map(fatura -> pagamentoMonitorado.pagar(fatura.toString()))
                .collect(Collectors.toList());

        faturaList.forEach(System.out::println);

//        10 -> 2 segundos
//                    100 -> 10

    }
}
