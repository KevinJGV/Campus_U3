import java.util.Scanner;

public class Ejercicio5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresar Año: ");
        short año = scanner.nextShort();
        float A = año % 19;
        float B = año % 4;
        float C = año % 7;
        float D = (19 * A +24) % 30;
        float E = (2 *B +4*C +6*D +5) % 7;
        float F = (22 +D +E);
        if (F <= 3) {
            System.out.println("Domingo de pascua cae en Marzo");
        } else if (F >= 31) {
            System.out.println("Domingo de pascua cae en Abril");
        };
    }
}
