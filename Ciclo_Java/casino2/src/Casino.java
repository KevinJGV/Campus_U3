import java.util.Scanner;

public class Casino {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int saldo = 5;
        while (saldo > 0 && saldo < 11) {
            int seleccion = 0;
            do {
                System.out.println("Amigo Ludopata, adivine el numero del dado [1 - 6]");
                seleccion = scanner.nextInt();
            } while (seleccion < 1 || seleccion > 6);
            int nAleatorio = 0;
            for (int i = 0; i < 2; i++) {
                int tempAleatorio;
                do {
                    tempAleatorio = (int) (Math.random() * 7);
                } while (tempAleatorio <= 1 && tempAleatorio > 6);
                nAleatorio += tempAleatorio;
            }
            if (nAleatorio >= 2 && nAleatorio <= 6) {
                System.out.println("Suma resultante: " + nAleatorio + ". Haz ganado $1.");
                saldo++;
            } else if (nAleatorio == 7){
                System.out.println("Suma resultante: " + nAleatorio + ". Haz ganado $5.");
                saldo--;
            } else 
            System.out.println("Saldo actual: $" + saldo);
        }
        if (saldo == 0) {
            System.out.println("Game Over. Eso te pasa por ludopata.");
        } else System.out.println("You Win. Igual despues te vas a quedar sin plata por ludopata.");
    }
}
