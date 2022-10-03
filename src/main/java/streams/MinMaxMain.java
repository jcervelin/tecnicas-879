package streams;

import optional.Carro;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class MinMaxMain {

    public static void main(String[] args) {

        Carro fusca = new Carro("VW","fuscao");
        Carro tempra = new Carro("Fiat", "Tempra");
        Carro porsche = new Carro("Porsche", "Cayanne");
        Carro bugatti = new Carro("Bugatti", "Noire");
        Carro mustang = new Carro("Ford", "mustang");
        Carro lamborghini = new Carro("Lamborghini", "Aventador");
        Carro jaguar = new Carro("Jaguar", "Terr");
        Carro rolls = new Carro("Rolls-Royce", "AB");
        Carro aston = new Carro("Aston Martin", "Valkyrie");

        Set<Carro> set = new TreeSet<>(Comparator.comparing(Carro::getModelo));
        set.add(aston);

        List<List<Carro>> todosCarros = List.of(List.of(fusca, tempra, porsche, bugatti), List.of( mustang, lamborghini, jaguar, rolls), List.of(aston));

        final List<Carro> collect = todosCarros.stream()
                .flatMap(carros -> carros.stream())
                .filter(carro -> carro.getMarca().trim().length() > 2)
                .peek(carro -> carro.setMarca(" Modificado " + carro.getMarca()))
                .map(carro -> {
                    carro.setMarca(" De novo " + carro.getMarca());
                    return carro;
                })
                .collect(Collectors.toList());

        final List<String> strings = null;

        final int min = emptyIfNull(strings).stream()
                .mapToInt(Integer::parseInt)
                .min().orElse(-1);

        final double avg = emptyIfNull(strings).stream()
                .mapToInt(Integer::parseInt)
                .average()
                .orElse(0.0);

        System.out.println(min);
        System.out.println(avg);
    }

    public static <T> List<T> emptyIfNull(List<T> list) {
        return list == null ? Collections.emptyList() : list;
    }
}
