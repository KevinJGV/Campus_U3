import java.util.HashMap;
import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Seleccione ejercicio del punto 1 (a-e): ");
        String fork = scanner.nextLine().toLowerCase();
        int variable = 0;
        HashMap<String, String> mensajes = new HashMap<>();
        mensajes.put("a", "Ingresar un valor representando ser un angulo: ");
        mensajes.put("b", "Ingresar un valor representando ser grados celsius: ");
        mensajes.put("c", "Ingresar un numero: ");
        mensajes.put("d", "if (x > y && y < z) {\n int p = scanner.nextInt();\n};");
        mensajes.put("e", "if (distancia > 20 && distancia < 35) {\n int tiempo = scanner.nextInt();\n};");
        switch (fork) {
            case "a":
                System.out.print(mensajes.get(fork));
                variable = scanner.nextInt();
                if (variable == 90) {
                    System.out.println("Angulo recto.");
                } else {
                    System.out.print("Angulo != Recto");
                };
                break;
            case "b":
                System.out.print(mensajes.get(fork));
                variable = scanner.nextInt();
                if (variable > 100) {
                    System.out.println("Por encima del punto de ebullición del agua.");
                } else {
                    System.out.print("Por debajo del punto de ebullición del agua.");
                };
                break;
            case "c":
                System.out.print(mensajes.get(fork));
                variable = scanner.nextInt();
                int acum = 0;
                if (variable > 0) {
                    for (int i = 0; i <= variable; i++) {
                        acum += i;
                    };
                    System.out.println("Resultado: " + acum);
                } else if (variable < 0) {
                    for (int i = 0; i >= variable; i--) {
                        acum += i;
                    };
                    System.out.println("Resultado: " + acum);
                } else {
                    System.out.print("Resultado: 0");
                };
                break;
            case "d":
                System.out.print(mensajes.get(fork));
                break;
            case "e":
                System.out.print(mensajes.get(fork));
                break;
            default:
                System.out.println("Ninguna opción coincide. Ejecute nuevamente");
                break;
        }
    }
}
