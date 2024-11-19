import java.util.Scanner;

// Este ejercicio utiliza el metodo replace para reemplazar un caracter de una cadena ingresada por el usuario
public class replace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresar cadena: ");
        String cadena = "";
        do {
            cadena = scanner.nextLine().toLowerCase();
        } while (cadena.isEmpty());
        System.out.print("Ingresar caracter a reemplazar en la cadena anterior:");
        char objetivo = scanner.next().toLowerCase().charAt(0);
        System.out.print("Ingresar caracter reemplazo:");
        char reemplazo = scanner.next().toLowerCase().charAt(0);
        System.out.println(cadena.replace(objetivo,reemplazo));
    }
}
