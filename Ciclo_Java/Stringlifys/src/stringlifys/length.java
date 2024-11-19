import java.util.Scanner;

// Este ejercicio utiliza el metodo lenght para encontar la longitud de una cadena ingresada por el usuario
public class length {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresar cadena: ");
        String cadena = "";
        do {
            cadena = scanner.nextLine().toLowerCase();
        } while (cadena.isEmpty());
        System.out.print("Longitud de cadena = " + cadena.length());
    }
}
