package introduccion;

/*
Ejercicio 2 Mostrar primos en un rango
Divide el trabajo de encontrar números primos entre 4 hilos para el rango de 1 a 1000.

Instrucciones:
1. Divide el rango de 1 a 1000 en 4 subrangos:
    Hilo 1: 1 a 250
    Hilo 2: 251 a 500
    Hilo 3: 501 a 750
    Hilo 4: 751 a 1000
2. Cada hilo debe encontrar los números primos en su rango y mostrarlos en pantalla.
3. El programa principal debe mostrar un mensaje indicando que todos los hilos han terminado.
Mostrar el resultado de los primos en orden ascendente.
 */

import java.util.ArrayList;
import java.util.Arrays;

class EncontrarPrimos implements Runnable {
    private int inicio;
    private int fin;

    // Constructor que define el rango
    public EncontrarPrimos(int inicio, int fin) {
        this.inicio = inicio;
        this.fin = fin;
    }

    // Método que realiza la suma en el rango
    @Override
    public void run() {
        ArrayList<Integer> primos = new ArrayList<Integer>();
        for(int i= inicio; i < fin; i++) {
            if (esPrimo(i)) primos.add(i);
        }
        System.out.println("\nLos primos del rango " +
                inicio + " a " + fin + ": \n" + primos.toString());
    }

    private boolean esPrimo(int n) {
        if (n < 2) return false;
        if  (n == 2 || n == 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;

        for (int i = 5; i <= Math.sqrt(n); i+= 6) {
            if (n % i == 0 || n % (i+2) == 0) return false;
        }
        return true;
    }
}

public class MostrarPrimos {
    public static void main(String[] args) {
        int[][] rangos = {
                {1, 250},
                {251, 500},
                {501, 750},
                {751, 1000}
        };

        // Crear e iniciar los hilos
        for (int i = 0; i < 4; i++) {
            Thread hilo = new Thread(new EncontrarPrimos(rangos[i][0], rangos[i][1]));
            hilo.start();
        }
    }
}
