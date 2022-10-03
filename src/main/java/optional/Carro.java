package optional;


public class Carro implements Comparable<Carro> {

    @Override
    public String toString() {
        return "Carro{" +
                "motor=" + motor +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                '}';
    }

    public Carro() {
    }

    private Motor motor;
    private String marca;
    private String modelo;

    public Motor getMotor() {
        return motor;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setMotor(Motor motor) {
        this.motor = motor;
    }
}
