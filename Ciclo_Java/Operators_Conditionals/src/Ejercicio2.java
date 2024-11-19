import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese fecha DD/MM/AAAA: ");
        String date = scanner.nextLine();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fecha = LocalDate.parse(date,formato);
        System.out.print("Ingrese dias a sumarle: ");
        short suma = scanner.nextShort();
        System.out.print("Fecha resultante: " + fecha.plusDays(suma));
    }
}
