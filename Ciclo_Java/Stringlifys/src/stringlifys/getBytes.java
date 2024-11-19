import java.util.Arrays;
import java.util.Scanner;

// Este ejercicio utiliza el metodo getBytes para obtener los bytes en un array de un texto ingresado por el usuario
public class getBytes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresar cadena cualquiera: ");
        String cadena = "";
        do {
            cadena = scanner.nextLine().toLowerCase();
        } while (cadena.isEmpty());
        for (int i = 0; i < cadena.getBytes().length ; i++) {
            System.out.println(cadena.charAt(i) + " = " + cadena.getBytes()[i]);
        }
    }
}
