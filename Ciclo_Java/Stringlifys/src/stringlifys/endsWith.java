import java.util.Scanner;

// Este ejercicio utiliza el metodo endsWith para saber si una cadena ingresada por el usuario finaliza con otra cadena ingresada por el usuario
public class endsWith {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        System.out.print("Ingresar primer cadena cualquiera: ");
        String cadena1 = "";
        do {
            cadena1 = scanner.nextLine().toLowerCase().intern();
        } while (cadena1.isEmpty());
        System.out.print("Ingresar segunda cadena para evaluar con el final de la primera: ");
        String cadena2 = "";
        do {
            cadena2 = scanner.nextLine().toLowerCase().intern();
        } while (cadena2.isEmpty());
        if (cadena1.endsWith(cadena2)) {
            System.out.println("'" + cadena2 +"' es parte del final de '" + cadena1 + "'.");
        } else System.out.println("No es parte del final de esta cadena.");
    }
}
