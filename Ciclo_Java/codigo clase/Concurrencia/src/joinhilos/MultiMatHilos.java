package joinhilos;

import java.security.SecureRandom;
import java.util.Arrays;

class Matriz {
    private int[][] matriz;
    SecureRandom secureRandom = new SecureRandom();

    public Matriz(int filas, int columnas) {
        matriz = new int[filas][columnas];
        for (int i = 0; i < filas; i++) {
            Arrays.fill(matriz[i], 0);
        }

    }

    private int getRandomRange(int min, int max) {
        return secureRandom.nextInt((max - min) + 1) + min;
    }

    public void setRandomMatriz(int ini, int fin) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = (int) (getRandomRange(ini, fin));
            }
        }
    }

    public void setMatrizAt(int fila, int columna, int valor) {
        matriz[fila][columna] = valor;
    }

    public int[][] getMatriz() {
        return matriz;
    }

    public int getMatrizAt(int fila, int columna) {
        return matriz[fila][columna];
    }

    public int[] getMatrizFila(int fila) {
        return matriz[fila];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                sb.append(matriz[i][j] + "\t\t");
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}

class MatrizThread extends Runnable {
    private int[][] matriz1, matriz2, matriz3;
    private int filProcess;

    public MatrizThread(int[][] matriz1, int[][] matriz2, int filProcess) {
        this.matriz1 = matriz1;
        this.matriz2 = matriz2;
        this.filProcess = filProcess;
        //Crear e inicializar la matriz en ceros
        matriz3 = new int[matriz1.length][matriz2[0].length];
        for(int i = 0; i < matriz3.length; i++) {
            Arrays.fill(matriz3[i], 0);
        }
    }


    @Override
    public void run() {
        for (int cm2 = 0; cm2 < matriz2[0].length; cm2++) {
            int suma = 0;
            for (int cm1 = 0; cm1 < matriz1[0].length; cm1++) {
                suma += m1.getMatrizAt(filProcess, cm1) * m2.getMatrizAt(cm1, cm2);
            }
            filMat[cm2] = suma;
        }

        filMat = vRes;
    }
}

class MatrizMath implements Runnable {
    private Matriz m1, m2;
    private int[] filMat;
    private int filProcess;

    public MatrizMath(Matriz m1, Matriz m2) {
        this.m1 = m1;
        this.m2 = m2;
        this.filProcess = -1;
    }

    public Matriz multicarMatriz() {
        int filasM1 = m1.getMatriz().length;
        int columnasM2 = m2.getMatriz()[0].length;

        if (filasM1 != columnasM2) {
            return null;
        }

        int columnasM1 = m1.getMatriz()[0].length;
        int filasM2 = m2.getMatriz().length;


        Matriz matrizRes = new Matriz(filasM1, columnasM2);

        for (int fm1 = 0; fm1 < filasM1; fm1++) { // Recorrer las filas de A
            for (int cm2 = 0; cm2 < columnasM2; cm2++) { // Recorrer las columnas de B
                int suma = 0;
                for (int cm1 = 0; cm1 < columnasM1; cm1++) {
                    //C[i][j] = C[i][j] + (A[i][k] * B[k][j])
                    suma += m1.getMatrizAt(fm1, cm1) * m2.getMatrizAt(cm1, cm2);
                }
                matrizRes.setMatrizAt(fm1, cm2, suma);
            }

        }

        return matrizRes;
    }

    public void setProcess(int filaProcess) {
        this.filProcess = filaProcess;
    }

    private void multiFilxCol()  {
        if (filProcess == -1)  {
            filMat = null;
            return;
        }

        int columnasM2 = m2.getMatriz()[0].length;
        int[] vRes = new int[columnasM2];

        for (int cm2 = 0; cm2 < columnasM2; cm2++) {
            int suma = 0;
            for (int cm1 = 0; cm1 < m1.getMatriz()[0].length; cm1++) {
                suma += m1.getMatrizAt(filProcess, cm1) * m2.getMatrizAt(cm1, cm2);
            }
            filMat[cm2] = suma;
        }

        filMat = vRes;
    }

    public int[] getfilMat() {
        return filMat;
    }

    @Override
    public void run() {
        multiFilxCol();
    }
}

public class MultiMatHilos {
    public static void main(String[] args) {
        final int FILS = 20;
        final int COLS = 20;

        Matriz m1 = new Matriz(FILS, COLS);
        Matriz m2 = new Matriz(FILS, COLS);

        m1.setRandomMatriz(1, 10);
        m2.setRandomMatriz(1, 10);

        System.out.println(m1);
        System.out.println(m2);

        MatrizMath matrizOper = new MatrizMath(m1, m2);


        // Inicio del cronómetro
        long tiempoInicio = System.nanoTime();
        Matriz mRes = matrizOper.multicarMatriz();
        // Fin del cronómetro
        long tiempoTotal  = System.nanoTime() - tiempoInicio;
        System.out.println("O aproximadamente " + (tiempoTotal / 1_000_000.0) + " milisegundos.");

        //System.out.println(mRes);

        //int res = matrizOper.multiFilxCol(m1, m2, 0);
        //System.out.println(Arrays.toString(res));

        Thread[] hilos = new Thread[FILS];
        MatrizMath[] tareas  = new MatrizMath[FILS];
        for(int i=0; i<FILS; i++) {
            tareas[i] = new MatrizMath(m1, m2);
            tareas[i].setProcess(i);
            hilos[i] = new Thread(tareas[i]);
            hilos[i].start();
        }


        tiempoInicio = System.nanoTime();
        for(int i=0; i<FILS; i++) {
            try {
                hilos[i].join(); // Espera a que el hilo termine
            } catch (InterruptedException e) {
                System.err.println("Hilo interrumpido: " + hilos[i].getName());
            }
        }

        // fin de los hilos
        tiempoTotal  = System.nanoTime() - tiempoInicio;
        System.out.println("O aproximadamente " + (tiempoTotal / 1_000_000.0) + " milisegundos.");

//        for(int i=0; i<FILS; i++) {
//            System.out.println(Arrays.toString(tareas[i].getfilMat()));
//        }
    }
}
