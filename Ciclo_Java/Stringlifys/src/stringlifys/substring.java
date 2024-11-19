import java.util.Scanner;

// Este ejercicio utiliza el metodo substring para obtener una subcadena  ingresada por el usuario en otra cadena ingresada por el usuario con el indice
public class substring {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        System.out.print("Ingresar cadena cualquiera: ");
        String cadena1 = "";
        do {
            cadena1 = scanner.nextLine().toLowerCase().intern();
        } while (cadena1.isEmpty());
        System.out.print("Ingresar segunda cadena cualquiera: ");
        int index = 0;
        do {
            index = scanner.nextByte();
        } while (index <= 0 || index > cadena1.length() - 1) ;
        System.out.println("Subcadena: " + cadena1.substring(index));
    }
}
