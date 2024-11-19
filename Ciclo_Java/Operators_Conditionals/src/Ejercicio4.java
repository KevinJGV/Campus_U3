import java.util.Scanner;
import java.util.Arrays;

public class Ejercicio4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresar Hora en formato de 24H: ");
        String time = scanner.nextLine();
        String[] time_Parts = time.split(":");
        int hours = Integer.parseInt(time_Parts[0]);
        String minutes = time_Parts[1];

        if (time_Parts[0].equals("00")) {
            System.out.print("Hora en 12H: 12:" + minutes + " AM");
        } else if (time_Parts[0].equals("12")) {
            System.out.print("Hora en 12H: 12:" + minutes + " PM");
        } else if (hours < 12) {
            System.out.print("Hora en 12H: " + hours + ":" + minutes + " AM");
        } else {
            System.out.print("Hora en 12H: " + (hours - 12) + ":" + minutes + " PM");
        }
    }
}
