import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingresa la matricula del vehiculo: ");
        String matricula = scanner.nextLine();

        System.out.print("Ingresa la marca del vehiculo: ");
        String marca = scanner.nextLine();

        System.out.print("Ingresa el modelo del vehiculo: ");
        Long modelo = scanner.nextLong();

        System.out.print("Ingresa el km del vehiculo: ");
        Long km = scanner.nextLong();

        Carro carro = new Carro(matricula, marca, modelo, km);

        carro.mostrarInformacion();

        scanner.close();
    }
}