import java.util.Scanner;
// Este ejercicio utiliza el metodo charAt para recorrer una cadena ingresada por el usuario para encontrar la posicion del primer caracter que lo contenga
public class charAt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresar cadena cualquiera: ");
        String cadena = "";
        do {
            cadena = scanner.nextLine().toLowerCase();
        } while (cadena.isEmpty());
        System.out.print("Ingresar caracter a encontrar en la cadena anterior:");
        char objetivo = scanner.next().toLowerCase().charAt(0);
        for (int i = 0; i <= cadena.length() ; i++) {
            if (cadena.charAt(i) == objetivo) {
                System.out.println("Primera posicion del caracter '" + objetivo + "' en '" + cadena + "': index = " + i);
                break;
            }
        }
    }
}
