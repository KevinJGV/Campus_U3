package introduccion;


/*
 * Ejercicio 1: Suma de un rango de números
Descripción:
Escribe un programa que divida el cálculo de la suma de los números de 1 a 1000 entre 4 hilos. Cada hilo calculará la suma de un rango específico, y el programa principal mostrará la suma total.

Instrucciones:

1. Divide los númerosRunnable de 1 a 1000 en 4 rangos:
- Hilo 1: 1 a 250
- Hilo 2: 251 a 500
- Hilo 3: 501 a 750
- Hilo 4: 751 a 1000
2. Usa un hilo para cada rango y calcula la suma parcial e imprímela en la consola.
 */

// Clase que implementa la lógica de la suma en un rango
class SumaRango implements Runnable {
    private int inicio;
    private int fin;
    private int sumaParcial;

    // Constructor que define el rango
    public SumaRango(int inicio, int fin) {
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
}

public class EjercicioSumatoria {
    public static void main(String[] args) {
        /*fThread[] hilos = new Thread[4];
        SumaRango[] tareas = new SumaRango[4];*/

        // Definir los rangos
        int[][] rangos = {
                {1, 250},
                {251, 500},
                {501, 750},
                {751, 1000}
        };

        // Crear e iniciar los hilos
        for (int i = 0; i < 4; i++) {
            /*tareas[i] = new SumaRango(rangos[i][0], rangos[i][1]);
            hilos[i] = new Thread(tareas[i]);
            hilos[i].start();*/
            Thread hilo = new Thread(new SumaRango(rangos[i][0], rangos[i][1]));
            hilo.start();
        }

    }
}
