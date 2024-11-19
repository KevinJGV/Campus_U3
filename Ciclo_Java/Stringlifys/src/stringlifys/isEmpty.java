import java.util.Scanner;
// Este ejercicio utiliza el metodo indexOf para no dejar terminar el programa si el usuario ingresa una cadena vacia
public class isEmpty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresar cadena No vacía: ");
        String cadena = "";
        do {
            cadena = scanner.nextLine().toLowerCase();
        } while (cadena.isEmpty());
        System.out.print("Fin.");
    }
}
