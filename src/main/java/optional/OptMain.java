package optional;

import java.util.List;
import java.util.Optional;

public class OptMain {

    public static void main(String[] args) {

        Carro carro = new Carro();

        boolean isValid = validaCarro(carro);


    }

    // validar se esta tudo populado
    public static boolean validaCarro(Carro carro1) {
        if (carro1.getMotor() == null) {
            throw new RuntimeException();
        }

        if (carro1.getMotor().getEngrenagem() == null) {
            throw new RuntimeException();
        }

        if (carro1.getMotor().getEngrenagem().getVela() == null) {
            throw new RuntimeException();
        }
        return true;
    }

    public static void validaCarroOpt(Carro carro) {
        final var optionalCarro = Optional.ofNullable(carro);
        optionalCarro
                .map(Carro::getMotor)
                .map(Motor::getEngrenagem)
                .map(Engrenagem::getVela)
                .orElseThrow(RuntimeException::new);
    }

    // map transformar ==> mapear
}