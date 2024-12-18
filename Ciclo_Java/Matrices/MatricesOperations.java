public class MatricesOperations {

    // Método para sumar dos matrices
    public static int[][] sumarMatrices(int[][] matrizA, int[][] matrizB) {
        int filas = matrizA.length;
        int columnas = matrizA[0].length;
        int[][] resultado = new int[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                resultado[i][j] = matrizA[i][j] + matrizB[i][j];
            }
        }
        return resultado;
    }

    // Método para restar dos matrices
    public static int[][] restarMatrices(int[][] matrizA, int[][] matrizB) {
        int filas = matrizA.length;
        int columnas = matrizA[0].length;
        int[][] resultado = new int[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                resultado[i][j] = matrizA[i][j] - matrizB[i][j];
            }
        }
        return resultado;
    }

    // Método para multiplicar dos matrices
    public static int[][] multiplicarMatrices(int[][] matrizA, int[][] matrizB) {
        int filasA = matrizA.length;
        int columnasA = matrizA[0].length;
        int columnasB = matrizB[0].length;
        int[][] resultado = new int[filasA][columnasB];

        for (int i = 0; i < filasA; i++) {
            for (int j = 0; j < columnasB; j++) {
                for (int k = 0; k < columnasA; k++) {
                    resultado[i][j] += matrizA[i][k] * matrizB[k][j];
                }
            }
        }
        return resultado;
    }

    // Método para imprimir una matriz
    public static void imprimirMatriz(int[][] matriz) {
        for (int[] fila : matriz) {
            for (int elemento : fila) {
                System.out.print(elemento + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Ejemplo de uso
        int[][] matrizA = {
            {1, 2, 3},
            {4, 5, 6}
        };

        int[][] matrizB = {
            {7, 8, 9},
            {10, 11, 12}
        };

        int[][] matrizC = {
            {1, 2},
            {3, 4},
            {5, 6}
        };

        System.out.println("Suma de matrices A + B:");
        imprimirMatriz(sumarMatrices(matrizA, matrizB));

        System.out.println("\nResta de matrices A - B:");
        imprimirMatriz(restarMatrices(matrizA, matrizB));

        System.out.println("\nMultiplicación de matrices A * C:");
        imprimirMatriz(multiplicarMatrices(matrizA, matrizC));
    }
}
