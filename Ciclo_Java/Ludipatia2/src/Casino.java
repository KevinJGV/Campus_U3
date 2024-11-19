// import java.util.List

public class Casino {
    public static void main(String[] args) {
        // Scanner scanner = new Scanner(System.in);
        int saldo = 5;
        while (saldo > 0 && saldo < 13) {
            int seleccion;
            do {
                System.out.println("Amigo Ludopata, adivine el numero del dado [1 - 6]");
                seleccion = scanner.nextInt();
            } while (seleccion < 1 || seleccion > 6);
            int nAleatorio;
            do {
                nAleatorio = (int) (Math.random() * 7);
            } while (nAleatorio <= 1 && nAleatorio > 6);
            if (nAleatorio == seleccion) {
                System.out.println("Dado arrojo: " + nAleatorio + ". Haz ganado $1.");
                saldo++;
            } else {
                System.out.println("Dado arrojo: " + nAleatorio + ". Haz perdido $1.");
                saldo--;
            }
            System.out.println("Saldo actual: $" + saldo);
        }
        if (saldo == 0) {
            System.out.println("Game Over. Eso te pasa por ludopata.");
        } else System.out.println("You Win. Igual despues te vas a quedar sin plata por ludopata.");
    }
}
