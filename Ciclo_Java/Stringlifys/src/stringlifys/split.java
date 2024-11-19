import java.util.Arrays;
import java.util.Scanner;

// Este ejercicio utiliza el metodo split para separar una cadena ingresada por el usuario segun un patron definido por este
public class split {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresar cadena a dividir: ");
        String cadena = "";
        do {
            cadena = scanner.nextLine().toLowerCase().intern();
        } while (cadena.isEmpty());
        System.out.print("Ingresar patron divisor:");
        String objetivo = "";
        do {
            objetivo = scanner.nextLine().toLowerCase().intern();
        } while (objetivo.isEmpty());
        if (cadena.contains(objetivo)) {
            System.out.println(Arrays.toString(cadena.split(objetivo)));
        } else System.out.println("Este divisor no se encuentra en la cadena.");

    }
}
