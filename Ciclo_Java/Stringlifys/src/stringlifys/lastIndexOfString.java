import java.util.Scanner;

// Este ejercicio utiliza el metodo lastIndexOf para encontrar la posicion del ultimo string que se le entrege en una cadena ingresada por el usuario previamente
public class lastIndexOfString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresar cadena cualquiera: ");
        String cadena = "";
        do {
            cadena = scanner.nextLine().toLowerCase();
        } while (cadena.isEmpty());
        System.out.print("Ingresar string a encontrar en la cadena anterior:");
        String objetivo = "";
        do {
            objetivo = scanner.nextLine().toLowerCase().intern();
        } while (objetivo.isEmpty());
        if (cadena.indexOf(objetivo) != -1) {
            System.out.print("String inicia en la poscion " + cadena.lastIndexOf(objetivo));
        } else System.out.println("String no esta en la cadena.");
    }
}