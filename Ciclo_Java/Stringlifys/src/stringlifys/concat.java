import java.util.Scanner;
// Este ejercicio utiliza el metodo concat para concatenar una cadena ingresada por el usuario con "Mundo Cruel!"
public class concat {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        System.out.print("Cadena a concatenar con 'Mundo Cruel!: ");
        String cadena1 = "";
        do {
            cadena1 = scanner.nextLine().intern();
        } while (cadena1.isEmpty());
        String cadena2 = "Mundo Cruel!";
        System.out.println(cadena1.concat(cadena2));
    }
}
