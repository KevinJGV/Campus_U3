import java.util.Scanner;

// Este ejercicio utiliza el metodo lastIndexOf para encontrar la posicion del ultimo caracter que se le entrege en una cadena ingresada por el usuario previamente
public class lastIndexOfChar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresar cadena cualquiera: ");
        String cadena = "";
        do {
            cadena = scanner.nextLine().toLowerCase();
        } while (cadena.isEmpty());
        System.out.print("Ingresar caracter a encontrar en la cadena anterior:");
        char objetivo = scanner.next().toLowerCase().charAt(0);
        if (cadena.lastIndexOf(objetivo) != -1) {
            System.out.print("Caracter en la poscion " + cadena.lastIndexOf(objetivo));
        } else System.out.println("Caracter no esta en la cadena.");
    }
}
