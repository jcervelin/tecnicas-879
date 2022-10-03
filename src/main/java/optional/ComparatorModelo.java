package optional;

import java.util.Comparator;

public class ComparatorModelo implements Comparator<Carro> {
    @Override
    public int compare(Carro o1, Carro o2) {
        return o2.getModelo().compareTo(o1.getModelo());
    }
}
