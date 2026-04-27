public class Carro extends Vehiculo {
    Long km;

    public Carro(String matricula, String marca, Long modelo, Long km) {
        super(matricula, marca, modelo);
        this.km = km;
    }
}
