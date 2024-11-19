import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el valor de a: ");
        double a = scanner.nextDouble();
        System.out.print("Ingrese el valor de b: ");
        double b = scanner.nextDouble();
        System.out.print("Ingrese el valor de c: ");
        double c = scanner.nextDouble();

        double discriminante = Math.pow(b, 2) - 4 * a * c;

        System.out.println("Discriminante (Δ) = " + discriminante);

        if (discriminante > 0) {

            double x1 = (-b + Math.sqrt(discriminante)) / (2 * a);
            double x2 = (-b - Math.sqrt(discriminante)) / (2 * a);
            System.out.println("La ecuación tiene dos raíces reales diferentes:");
            System.out.println("x1 = " + x1);
            System.out.println("x2 = " + x2);
        } else if (discriminante == 0) {

            double x = -b / (2 * a);
            System.out.println("La ecuación tiene una raíz real de multiplicidad 2:");
            System.out.println("x = " + x);
        } else {
            System.out.println("La ecuación no tiene raíces reales.");
        };
    }
}
