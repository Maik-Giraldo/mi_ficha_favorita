public class Circulo extends Figura{
    Double radio;

    public Circulo(Double radio) {
        this.radio = radio;
    }

    @Override
    public Double calcularArea() {
        return Math.PI * (radio * radio);
    }
}
