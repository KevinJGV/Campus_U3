import java.util.Scanner;

// Este ejercicio utiliza el metodo indexOf para encontrar la posicion del primer caracter que se le entrege en una cadena ingresada por el usuario previamente
public class indexOfChar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresar cadena cualquiera: ");
        String cadena = "";
        do {
            cadena = scanner.nextLine().toLowerCase();
        } while (cadena.isEmpty());
        System.out.print("Ingresar caracter a encontrar en la cadena anterior:");
        char objetivo = scanner.next().toLowerCase().charAt(0);
        if (cadena.indexOf(objetivo) != -1) {
            System.out.print("Caracter en la poscion " + cadena.indexOf(objetivo));
        } else System.out.println("Caracter no esta en la cadena.");
    }
}
