public class Vehiculo {
    private String matricula;
    private String marca;
    private Long modelo;

    public Vehiculo(String matricula, String marca, Long modelo) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
    }

    public void mostrarInformacion() {
        System.out.println("El vehiculo es un: " + this.marca + " con matricula: " + this.matricula + " y modelo: " + this.modelo);
    }
}
