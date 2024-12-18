package introduccion;


/*
 * Ejercicio 1: Suma de un rango de números
Descripción:
Escribe un programa que divida el cálculo de la suma de los números de 1 a 1000 entre 4 hilos. Cada hilo calculará la suma de un rango específico, y el programa principal mostrará la suma total.

Instrucciones:

1. Divide los números de 1 a 1000 en 4 rangos:
- Hilo 1: 1 a 250
- Hilo 2: 251 a 500
- Hilo 3: 501 a 750
- Hilo 4: 751 a 1000
2. Usa un hilo para cada rango y calcula la suma parcial e imprímela en la consola.
 */

import java.util.function.Consumer;

// Clase que implementa la lógica de la suma en un rango
class SumaRango2 implements Runnable {
    private int inicio;
    private int fin;
    private int sumaParcial;

    // Constructor que define el rango
    public SumaRango2(int inicio, int fin) {
        this.inicio = inicio;
        this.fin = fin;
    }

    // Método que realiza la suma en el rango
    @Override
    public void run() {
        sumaParcial = 0; // Inicializa la suma en 0
        for (int i = inicio; i <= fin; i++) {
            sumaParcial += i;
        }
        System.out.println("Suma parcial del rango " + inicio + " a " + fin + ": " + sumaParcial);
    }

    public int getSumaParcial() {
        return sumaParcial;
    }
}

public class EjercicioSumatoria2 {
    public static void main(String[] args) {
        Thread[] hilos = new Thread[4];
        SumaRango2[] tareas = new SumaRango2[4];

        System.out.println("INICIO");

        // Definir los rangos
        int[][] rangos = {
                {1, 250},
                {251, 500},
                {501, 750},
                {751, 1000}
        };

        // Crear e iniciar los hilos
        for (int i = 0; i < 4; i++) {
            tareas[i] = new SumaRango2(rangos[i][0], rangos[i][1]);
            hilos[i] = new Thread(tareas[i]);
            hilos[i].start();
        }

        // Esperar a que todos los hilos terminen
        for (int i = 0; i < 4; i++) {
            try {
                hilos[i].join(); // Espera a que el hilo termine
                System.out.println("JOIN");
            } catch (InterruptedException e) {
                System.err.println("Hilo interrumpido: " + hilos[i].getName());
            }
        }

        // Calcular la suma total
        int sumaTotal = 0;
        for (int i = 0; i < 4; i++) {
            sumaTotal += tareas[i].getSumaParcial();
        }

        // Mostrar el resultado final
        System.out.println("Suma total: " + sumaTotal);

        System.out.println("FIN");


    }
}
