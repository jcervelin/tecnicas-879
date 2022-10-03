package streams;

import optional.Carro;
import optional.Motor;

import java.util.AbstractQueue;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeSet;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMain {

    public static void main(String[] args) {
       // List<Carro> paresEImpares = List.of(2,5,9,7,8,10,15,22);
        List<Carro> paresEImpares = List.of(new Carro(),new Carro(),new Carro());
        Stream<Integer> paresEImparesSt = Stream.of(2,5,9,7,8,10,15,22);

        var reduce = paresEImparesSt
                .reduce( (acc, e2) -> {
                    return acc + e2;
                } );

        List<List<Integer>> listList = List.of(List.of(1,2,3),List.of(4,5,6));
       // Stream<Stream<Integer>> listList = Stream.of(Stream.of(1,2,3),Stream.of(4,5,6));


        // flatMap NAO junta lista
        // flatMap junta STREAMS

        final List<Integer> collect = listList.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
    // reduce



        // .stream()
        // criar lista com numeros pares //Operações intermediárias
            var novaLista = paresEImpares
                .stream()
                //alterei de carro para novoCarro
                .peek(c -> c.setMotor(new Motor()))
                .map(c -> converteCarro(c))
                .limit(5)
                 //xereta o carro, mas nao o transforma
                    .sorted()
//                .map(e -> e / 3)
//                .skip(1)
//                .distinct()
//                .limit(2)
              //  .filter(e -> e % 2 == 0)
                .collect(Collectors.toList());
        Stream<Integer> x = Stream.of(2,5,9,7,8,10,15,22);

        System.out.println(paresEImpares);
        System.out.println(novaLista);
    }

    private static NovoCarro converteCarro(Carro c) {
        final NovoCarro novoCarro = new NovoCarro(c);
        return novoCarro;
    }
// heap
    protected static PriorityBlockingQueue<TreeSet<Integer>> priorityBlockingQueue;
    protected static PriorityQueue<LinkedHashSet<Queue<Integer>>> sets;
    public static AbstractQueue<Stream<Stream<LinkedTransferQueue<Integer>>>> oi;
}
