import java.util.Scanner;

// Este ejercicio utiliza el metodo startsWith para saber si una cadena ingresada por el usuario inicia con otra cadena ingresada por el usuario
public class startsWith {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        System.out.print("Ingresar primer cadena cualquiera: ");
        String cadena1 = "";
        do {
            cadena1 = scanner.nextLine().toLowerCase().intern();
        } while (cadena1.isEmpty());
        System.out.print("Ingresar segunda cadena para evaluar con el inicio de la primera: ");
        String cadena2 = "";
        do {
            cadena2 = scanner.nextLine().toLowerCase().intern();
        } while (cadena2.isEmpty());
        if (cadena1.startsWith(cadena2)) {
            System.out.println("'" + cadena2 +"' es parte del inicio de '" + cadena1 + "'.");
        } else System.out.println("No es parte del inicio de esta cadena.");
    }
}
