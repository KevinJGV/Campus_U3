import java.lang.reflect.Array;
import java.util.Arrays;

public class SweetCO {
    public static void main(String[] args) {
        int[][] ventas = {
                {100, 88, 92, 94, 85, 110, 118},
                {30, 42, 31, 32, 38, 40, 37},
                {23, 35, 39, 45, 55, 60, 61},
                {45, 50, 56, 65, 45, 57, 68},
                {18, 25, 33, 21, 22, 28, 32}
        };

        int[] precio = {1500, 5000, 6500, 2500, 2250};

        System.out.println("El producto que genera más ingresos es: " +
                prodMasIngresos(ventas, precio));
        System.out.println("El dia que genera más ingresos es: " +
                diaMasIngresos(ventas, precio));
    }

    private static String prodMasIngresos(int[][] ventas, int[] precio) {
        int[] vtasprod = new int[precio.length];
        Arrays.fill(vtasprod, 0);

        int vtasmax = -1;
        int prodmasvende = 0;

        for (int i = 0; i < ventas.length; i++) {
            for (int j = 0; j < ventas[i].length; j++) {
                vtasprod[i] += ventas[i][j] * precio[i];
            }

            if (vtasprod[i] > vtasmax) {
                vtasmax = vtasprod[i];
                prodmasvende = i + 1;
            }
        }

        return prodmasvende + "";
    }
    public static int diaMasIngresos(int[][] ventas, int[] precio) {
        int indiceMayor = 0;
        int[] valorDia = new int[ventas[0].length];
        for (int i = 0; i < ventas.length; i++) {
            for (int j = 0; j < ventas[i].length; j++) {
                valorDia[j] += ventas[i][j] * precio[i];
                if (valorDia[j] > indiceMayor) indiceMayor =  Arrays.binarySearch(valorDia,valorDia[j]) + 1;
            }
        }
        System.out.println(Arrays.toString(valorDia));
        return indiceMayor;
    }
}
