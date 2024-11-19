import java.util.Scanner;

// Este ejercicio utiliza el metodo replaceAll para reemplazar los strings coincidentes de una cadena ingresada por el usuario
public class replaceAll {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresar cadena: ");
        String cadena = "";
        do {
            cadena = scanner.nextLine().toLowerCase();
        } while (cadena.isEmpty());
        System.out.print("Ingresar string a reemplazar en la cadena anterior:");
        String objetivo = "";
        do {
            objetivo = scanner.nextLine().toLowerCase().intern();
        } while (objetivo.isEmpty());
        System.out.print("Ingresar string reemplazo:");
        String reemplazo = "";
        do {
            reemplazo = scanner.nextLine().toLowerCase().intern();
        } while (reemplazo.isEmpty());
        System.out.println(cadena.replaceAll(objetivo,reemplazo));
    }
}
