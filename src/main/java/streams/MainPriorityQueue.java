package streams;

import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class MainPriorityQueue {

    public static void main(String[] args) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        // min heap
        // max heap

        pq.add(9);
        pq.add(10);
        pq.add(2);
        pq.add(8);
        pq.add(4);
        pq.add(6);

        // pq.peek() O(1)
        System.out.println(pq.peek());
        // 2 4 6 8 9 10
        // primeiro elemento
        // ultimo elemento
        // maior elemento
        // menor elemento

        final List<Integer> collect = pq
                .stream()
                .map(integer -> {
                    System.out.println(integer);
                    return integer;
                }).collect(Collectors.toList());



    }
}
