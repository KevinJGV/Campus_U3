import java.util.Scanner;

public class fizzbuzz {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresar valor de N (1 - 10000): ");
        int n = scanner.nextInt();
        if (n >= 1 && n <= 10000) {
            String s = "";
            for (int i = 1; i <= n ; i++) {
                if (i % 3 == 0) {
                    if (i % 5 == 0) {
                        System.out.println("FizzBuzz");
                    } else {
                        System.out.println("Fizz");
                    };
                } else if (i % 5 == 0) {
                    System.out.println("Buzz");
                } else System.out.println(i);
            }
        } else System.out.println("Valor fuera del rango.");

    }
}
