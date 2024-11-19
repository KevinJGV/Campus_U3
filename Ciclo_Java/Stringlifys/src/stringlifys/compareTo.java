import java.util.Scanner;

// Este ejercicio utiliza el metodo compareTo para saber si una cadena ingresada por el usuario es igual a otra cadena ingresada por el usuario
public class compareTo {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        System.out.print("Ingresar primer cadena cualquiera: ");
        String cadena1 = "";
        do {
            cadena1 = scanner.nextLine().toLowerCase().intern();
        } while (cadena1.isEmpty());
        System.out.print("Ingresar segunda cadena cualquiera: ");
        String cadena2 = "";
        do {
            cadena2 = scanner.nextLine().toLowerCase().intern();
        } while (cadena2.isEmpty());
        if (cadena2.compareTo(cadena1) == 0) {
            System.out.println("Cadena primera y segunda son iguales.");
        } else System.out.println("Cadenas diferentes.");
    }
}
