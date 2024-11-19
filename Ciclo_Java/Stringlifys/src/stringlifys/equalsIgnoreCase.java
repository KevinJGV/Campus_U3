import java.util.Scanner;

// Este ejercicio utiliza el metodo equalsIgnoreCase para saber si una cadena, construida con la clase String, ingresada por el usuario es igual a otra cadena ingresada por el usuario tambien construida ignorando mayusculas
public class equalsIgnoreCase {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        System.out.print("Ingresar primer cadena cualquiera: ");
        String cadena1;
        do {
            cadena1 = scanner.nextLine().toLowerCase();
        } while (cadena1.isEmpty());
        System.out.print("Ingresar segunda cadena cualquiera: ");
        String cadena2;
        do {
            cadena2 = scanner.nextLine().toLowerCase();
        } while (cadena2.isEmpty());
        if (cadena2.equalsIgnoreCase(cadena1)) {
            System.out.println("Cadena primera y segunda son iguales.");
        } else System.out.println("Cadenas diferentes.");
    }
}